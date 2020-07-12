import java.nio.ByteBuffer
import java.security.MessageDigest
import java.math.BigInteger


val arr = MessageDigest.
  getInstance("SHA-256").
  digest("some string".getBytes("UTF-8"))

String.format("%032x", new BigInteger(1, arr))

new String(arr)

var s = "hello world"

var bytes = s.getBytes()


String.format("%032x", new BigInteger(1, bytes))

val emptyArr = Array[Byte]()
