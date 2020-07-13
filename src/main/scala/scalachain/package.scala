package scalachain

import java.nio.{ByteBuffer, ByteOrder}
import java.math.BigInteger
import java.security.MessageDigest

package object utils {
  def getSha265Sum(arr: Array[Byte]): Array[Byte] =
    MessageDigest.getInstance("SHA-256").digest(arr)

  def hashToString(arr: Array[Byte]): String =
    if (arr.length == 0) ""
    else String.format("%064x", new BigInteger(1, arr))

  def bytesToString(arr: Array[Byte]): String =
    new String(arr)

  def longToBytes(l: Long): Array[Byte] =
    ByteBuffer.allocate(8).putLong(l).order(ByteOrder.BIG_ENDIAN).array()

  def intToBytes(i: Int): Array[Byte] =
    ByteBuffer.allocate(4).putInt(i).order(ByteOrder.BIG_ENDIAN).array()

}
