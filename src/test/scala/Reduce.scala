

import _root_.scala.collection.parallel.mutable.ParTrieMap
import _root_.scala.collection.parallel.ForkJoinTaskSupport

/*
/**
  * Created by benjamin on 11/01/16.
  */
object Map extends testing.Benchmark {
  val length = sys.props("length").toInt
  val par = sys.props("par").toInt
  val partrie = ParTrieMap((0 until length) zip (0 until length): _*)

  partrie.tasksupport = new ForkJoinTaskSupport(new scala.concurrent.forkjoin.ForkJoinPool(par))

  def run = {
    partrie map {
      kv => kv
    }
  }
}
*/