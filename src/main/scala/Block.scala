import java.nio.ByteBuffer
import java.security.MessageDigest
import scala.math.BigInt



class Block(val timestamp: Long, val prevBlockHash: Array[Byte], val hash: Array[Byte], val data: Array[Byte]) {

}

object Block {

  def apply(data: Array[Byte], prevBlockHash: Array[Byte]): Block = {
    val timestamp: Long = System.currentTimeMillis
    val hash = getHash(timestamp, prevBlockHash, data)
    new Block(timestamp, prevBlockHash, hash, data)
  }

  def getHash(timestamp: Long, prevBlockHash: Array[Byte], data: Array[Byte]): Array[Byte] = {
    val bTimestamp = ByteBuffer.allocate(8).putLong(timestamp).array()
    val headers = prevBlockHash ++ data ++ bTimestamp
    MessageDigest.getInstance("SHA-256").digest(headers)
  }

}
