package scalachain

import scala.collection.mutable.ArrayBuffer

class BlockChain(val blocks: ArrayBuffer[Block]) {
  def addBlock(data: Array[Byte]): Unit = {
    val previousHash = blocks.last.hash
    val b = Block(data, previousHash)
    blocks.append(b)
  }
}

object BlockChain {
  def apply(): BlockChain = {
    val block = Block("Genesis Block".getBytes, Array[Byte]())
    val blocks = ArrayBuffer(block)
    new BlockChain(blocks)
  }
}
