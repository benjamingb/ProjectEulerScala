package main.scala.P002

/**
  * Problem 2
  * Even Fibonacci numbers
  * @author Benjamin Gonzales
  */

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

case class Solution1(n: Int) {
  lazy val fs: Stream[Int] = 0 #:: 1 #:: fs.zip(fs.tail).map(p => p._1 + p._2)

  def maxSumNums = fs.takeWhile(_ <= n).filter(_ % 2 == 0).sum
}

case class Solution2(n: Int) {

  @tailrec
  private def getFibonacciElements(i: Int, elems: ListBuffer[Int]): ListBuffer[Int] = {
    if (i <= 1) getFibonacciElements(i + 1, elems.+=(i))
    else if (elems.last >= n) elems
    else getFibonacciElements(i + 1, elems.+=(elems(i - 1) + elems(i - 2)))
  }

  def maxSumNums = getFibonacciElements(0, ListBuffer()).filter(_ % 2 == 0).sum
}

case class Solution3(n: Int) {

  @tailrec
  private def getFibonacciElements(acc: Int, i: Int, elems: ListBuffer[Int]): Int = {
    if (i <= 1) getFibonacciElements(acc, i + 1, elems.+=(i))
    else if (elems.last >= n) acc
    else {
      val nextFibonacciElement: Int = elems(i - 1) + elems(i - 2)
      if (nextFibonacciElement % 2 == 0) getFibonacciElements(acc + nextFibonacciElement, i + 1, elems.+=(nextFibonacciElement))
      else getFibonacciElements(acc, i + 1, elems.+=(nextFibonacciElement))
    }
  }

  def maxSumNums = getFibonacciElements(0, 0, ListBuffer())
}
