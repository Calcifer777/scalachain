import Block._

object Main extends App {
  val timestamp: Long = System.currentTimeMillis
  val data = "ciao sono marco"
  val hash = getHash(timestamp: Long, Array[Byte](), data.getBytes)
  println("")
  println(hash)
}
