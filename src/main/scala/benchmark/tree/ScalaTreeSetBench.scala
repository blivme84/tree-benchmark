package benchmark.tree

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

import scala.collection.immutable.TreeSet

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class ScalaTreeSetBench {

  @Param(Array("10", "1000"))
  var size: Int = _

  var set: TreeSet[Double] = _

  var emptyset: TreeSet[Double] = _

  def buildSet(n: Int): TreeSet[Double] = {
    var i = 0
    var _set: TreeSet[Double] = TreeSet.empty[Double]
    while (i < size) {
      _set = _set + i.toDouble
      i += 1
    }
    _set
  }

  @Setup
  def setup(): Unit = {
    set = buildSet(size)
    emptyset = TreeSet.empty[Double]
  }

  @Benchmark
  def lookup: TreeSet[Double] = {
    set.to(size / 2)
  }

  @Benchmark
  def add: TreeSet[Double] = {
    set + (size / 2)
  }

  @Benchmark
  def remove: TreeSet[Double] = {
    set - (size / 2)
  }

  @Benchmark
  def min: Double = {
    set.min
  }

}
