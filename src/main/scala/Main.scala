import scala.language.implicitConversions
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer

import scalachain.{BlockChain, Block}
import scalachain.utils._

import com.typesafe.config.ConfigFactory


object Main extends App {

  implicit def stringToBytes(s: String): Array[Byte] = 
    s.getBytes(StandardCharsets.UTF_8)

  val blockChain = BlockChain()
  blockChain.addBlock("Send 1 BTC to Ivan")
  blockChain.addBlock("Send 2 more BTC to Ivan")
  blockChain.blocks.foreach({ b: Block => 
    println(s"Hash: ${hashToString(b.hash)}")
    println(s"Previous Hash: ${hashToString(b.prevBlockHash)}")
    println(s"Data: ${new String(b.data)}")
    println("\n")
  })


}
