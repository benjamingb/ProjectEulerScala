package main.scala



object Euler extends App {
  //Console.println("Hello World: " + (args(0)))
  //println("hola")
  val x = (1 until 1000).count(_ % 10 == 0)

  def y = {
    var x = 1
    var num = 0
    while(x < 1000) {
      if(x % 10 == 0) { num += 1 }
      x += 1
    }
    num
  }

  //println(Util.time{x})
  //println(Util.time{y})

  val f = (2 until 1000).view.filter(m => m % 3 == 0 || m % 5 == 0).sum
  val g = (2 until 1000).view.filter(m => m % 3 == 0 || m % 5 == 0).sum
  println(Util.time{f})
  println(Util.time{f})

 //Timex.measure( println(f))
 //Timex.measure(println(g))
}
