import scala.collection.mutable.ArrayBuffer

class BlockChain(val blocks: ArrayBuffer[Block]) {
  def addBlock(b: Block): Unit = blocks.append(b)
}


