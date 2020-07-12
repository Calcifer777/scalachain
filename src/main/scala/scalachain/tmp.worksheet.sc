import java.nio.ByteBuffer
import java.security.MessageDigest
import java.math.BigInteger

import scalachain.utils._
import scalachain._
import scala.math.BigInt



val s = "hello world"

val arr = s.getBytes()

val hash = MessageDigest.getInstance("SHA-256").digest(arr)

val bigInteger = new BigInteger(hash)
val bigInt = BigInt(bigInteger)
val bigIntFromHash = BigInt(hash)
hashToString(hash)


class ProofOfWork(val block: Block, val target: BigInt)

val target = BigInt(1)
target.toString(16)
val targetBits = 24
val shift = 256 - targetBits
val shifted = bigInt << shift

shifted.toString(16)

getSha265Sum(shifted.toByteArray)


val s1 = "I like donuts"
val sha1 = getSha265Sum(s1.getBytes())
val sha1Int = new BigInteger(1, sha1)
val sha1Str = 
  String.format("%064x", new BigInteger(1, sha1))

val s2 = "donutsca07ca"
val sha2 = getSha265Sum(s2.getBytes())
val sha2Str = 
  String.format("%064x", new BigInteger(1, sha2))


