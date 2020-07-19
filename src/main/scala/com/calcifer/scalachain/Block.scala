package com.calcifer.scalachain

import com.typesafe.config.ConfigFactory
import java.nio.ByteBuffer
import java.security.MessageDigest
import scala.math.BigInt
import scala.annotation.tailrec
import java.io.{
  ByteArrayInputStream,
  ByteArrayOutputStream,
  ObjectInputStream,
  ObjectOutputStream
}

import com.calcifer.scalachain.utils._

trait Block extends Serializable 

@SerialVersionUID(666L)
class MessageBlock(
    val timestamp: Long,
    val prevBlockHash: Array[Byte],
    val hash: Array[Byte],
    val data: Array[Byte],
    var nonce: Int
) extends Block {

  import MessageBlock._

  require(isValid(hash), s"Hash (${hash}) not valid")

  def isValid(hash: Array[Byte]): Boolean =
    BigInt(hashToString(hash), 16) <= target

}

object MessageBlock {

  val conf = ConfigFactory.load("application.conf");
  val targetBits = conf.getInt("targetBits.value")
  val target = BigInt(1) << (256 - targetBits)
  val maxNonce = Int.MaxValue

  def apply(data: Array[Byte], prevBlockHash: Array[Byte]): MessageBlock = {
    val timestamp: Long = System.currentTimeMillis
    val (nonce, hash) = getProofOfWork(prevBlockHash, data, timestamp)
    new MessageBlock(timestamp, prevBlockHash, hash, data, nonce)
  }

  def getProofOfWork(
      prevBlockHash: Array[Byte],
      data: Array[Byte],
      timestamp: Long
  ): (Int, Array[Byte]) = {
    println(
      s"""
      | Mining the block containing "${bytesToString(data)}"
      """.stripMargin('|')
    )
    @annotation.tailrec
    def loop(nonce: Int): (Int, Array[Byte]) = {
      val blockInfo = prepareData(prevBlockHash, data, timestamp, nonce)
      val hash = getSha265Sum(blockInfo)
      if (nonce % 100000 == 0) print(s"""Hash: ${hashToString(hash)}\r""")
      val hashInt = BigInt(hashToString(hash), 16)
      if (hashInt < target) {
        print(s"""Hash: ${hashToString(hash)}\r""")
        (nonce, hash)
      } else
        loop(nonce + 1)
    }
    loop(0)
  }

  def prepareData(
      prevBlockHash: Array[Byte],
      data: Array[Byte],
      timestamp: Long,
      nonce: Int
  ): Array[Byte] =
    prevBlockHash ++
      data ++
      longToBytes(timestamp) ++
      intToBytes(targetBits) ++
      intToBytes(nonce)

  def serialise(block: Block): Array[Byte] = {
    val stream: ByteArrayOutputStream = new ByteArrayOutputStream()
    val oos = new ObjectOutputStream(stream)
    oos.writeObject(block)
    oos.close()
    stream.toByteArray
  }

  def deserialise(bytes: Array[Byte]): Option[Block] = {
    val ois = new ObjectInputStream(new ByteArrayInputStream(bytes))
    val value = ois.readObject
    ois.close()
    value match {
      case b: Block => Some(b)
      case _        => None
    }
  }
}
