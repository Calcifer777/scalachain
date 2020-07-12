package scalachain

import java.math.BigInteger
import java.security.MessageDigest

package object utils {
  def getSha265Sum(arr: Array[Byte]): Array[Byte] =
    MessageDigest.getInstance("SHA-256").digest(arr)

  def hashToString(arr: Array[Byte]): String =
    if (arr.length == 0) ""
    else String.format("%032x", new BigInteger(arr))

  def bytesToString(arr: Array[Byte]): String =
    new String(arr)
}
