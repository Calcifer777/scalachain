package scalachain

import com.typesafe.config.ConfigFactory

import scalachain.utils._

class ProofOfWork(val block: Block, val target: BigInt) 

object ProofOfWork {

  val conf = ConfigFactory.load("application.conf");
  val targetBits = conf.getInt("targetBits.value")
  val maxNonce = Int.MaxValue

  def apply(block: Block): ProofOfWork = {
    val target = BigInt(1)
    val shift = 256 - targetBits
    val shifted = target << shift
    new ProofOfWork(block, shifted)
  }

  def prepareData(pow: ProofOfWork, nonce: Int): Array[Byte] = 
    pow.block.prevBlockHash ++
      pow.block.data ++
      pow.block.timestamp.toHexString.getBytes() ++
      targetBits.toHexString.getBytes() ++
      nonce.toHexString.getBytes()

  def run(pow: ProofOfWork): (Int, Array[Byte]) = {
    println(s"""Mining the block containing "${bytesToString(pow.block.data)}"""")
    def loop(nonce: Int): (Int, Array[Byte]) = {
      val data = prepareData(pow, nonce)
      val hash = getSha265Sum(data)
      println(s"""Hash "${hashToString(hash)}"""")
      val hashInt = BigInt(hash)
      if (hashInt < pow.target)
        (nonce, hash)
      else
        loop(nonce+1)
    }
    loop(0)
    (0, Array[Byte]())
  }
}
