package test.scala

//import collection.mutable.Stack
import org.scalatest._
import main.scala._

class Test extends FunSuite {

  //Problem 1
  test("Problem 1 Solution1 ") {
    assert(P001.Solution1(3, 5, 1000).sumMultiple ==233168)
  }
  test("Problem 1 Solution2 ") {
    assert(P001.Solution2(3, 5, 1000).sumMultiple ==233168)
  }

}