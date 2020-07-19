package com.calcifer.scalachain

import scala.collection.mutable.ArrayBuffer

class BlockChain(val blocks: ArrayBuffer[MessageBlock]) {
  def addBlock(data: Array[Byte]): Unit = {
    val previousHash = blocks.last.hash
    val b = MessageBlock(data, previousHash)
    blocks.append(b)
  }
}

object BlockChain {
  def apply(): BlockChain = {
    val block = MessageBlock("Genesis Block".getBytes, Array[Byte]())
    val blocks = ArrayBuffer(block)
    new BlockChain(blocks)
  }
}
