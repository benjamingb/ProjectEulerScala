package main.scala
/**
  * Created by benjamin on 08/01/16.
  */
object P003 {


  /*def solution1(n:Int) {
    def a() = 10
    def b() = 11
    println(a)
    a+b
  }*/

  /*def solution1(n: Long): List[Long] = {
    val result = (2 to math.sqrt(n).toInt).find(n % _ == 0).map(i => i.toLong :: solution1(n / i)).getOrElse(List(n))
    result
  }

  def solution2(n: Long): List[Long] = {
    val result = (3 to math.sqrt(n).toInt by 2).find(n % _ == 0).map(i => i.toLong :: solution2(n / i)).getOrElse(List(n))
    result
  }*/
}