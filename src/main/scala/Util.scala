package main.scala

object Util {
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    val display = (t1 - t0) + " ns | " + (t1 - t0) / 1000000f + " ms"
    println("Elapsed time: " + display)
    result
  }

  // Now wrap your method calls, for example change this...
  //val result = 1 to 1000 sum

  // ... into this
  //val result2 = time { 1 to 1000 sum }
}

object Timex {

  def measure(f: => Unit) = {
    val start = System.nanoTime()
    f
    println("Time spent: " + (System.nanoTime() - start) + " ns")
  }

}