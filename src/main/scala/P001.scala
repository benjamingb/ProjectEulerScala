package main.scala.P001

/**
  * Problem 1
  * Multiples of 3 and 5
  * @author Benjamin Gonzales
  */

import scala.annotation.tailrec


case class Solution1(num1: Int, num2: Int, numMax: Int) {
  val numbers = (2 until numMax).filter(m => m % num1 == 0 || m % num2 == 0)

  def sumMultiple = numbers.sum
}

case class Solution2(x: Int, y: Int, max: Int) {
  val numbers = for {
    n <- 2 until max
    if n % x == 0 || n % y == 0
  } yield n

  def sumMultiple = numbers.sum
}

/**
  * Algebraic Relationships
  *
  * Multiplo de 3
  * =============
  * SumStep
  * S = 3
  * n = 999
  * s * sumOnetoN(n / s) = 166833
  *
  * sumOnetoN
  * n = 333
  * (n * (n + 1)) / 2 = 55611
  *
  * Multiplo de 5
  * =============
  * SumStep
  * S = 5
  * n = 999
  * s * sumOnetoN(n / s) = 99500
  *
  * sumOnetoN
  * n = 199
  * (n * (n + 1)) / 2 = 19900
  *
  * RESTA Multiplo 3 - Multiplo 5
  * ==============================
  * SumStep
  * S = 15
  * n = 999
  * s * sumOnetoN(n / s) = 33165
  *
  * sumOnetoN
  * n = 66
  * (n * (n + 1)) / 2 = 2211
  *
  */
case class Solution3(num1: Int, num2: Int, numMax: Int) {
  private val untilNum = numMax - 1

  private def sumStep(s: Int, n: Int): Int = {
    s * sumOnetoN(n / s)
  }

  private def sumOnetoN(n: Int): Int = {
    n * (n + 1) / 2
  }

  def sumMultiple = sumStep(num1, untilNum) + sumStep(num2, untilNum) - sumStep(num1 * num2, untilNum)
}


case class Solution4(num1: Int, num2: Int, numMax: Int) {
  @tailrec
  private def sum(i: Int, acc: Int, bound: Int): Int = {
    if (i >= bound) acc
    else if (i % num1 == 0 || i % num2 == 0) sum(i + 1, acc + i, bound)
    else sum(i + 1, acc, bound)
  }

  def sumMultiple = sum(num1, 0, numMax)
}
