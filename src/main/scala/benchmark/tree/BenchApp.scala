package benchmark.tree

import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.results.{Result => BenchResult}
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options._

import scala.collection.JavaConverters._

object BenchApp {

  def main(args: Array[String]): Unit = {

    // confs
    val opts0 = BenchAppConfs.envOptions(args.toList)
    val opts1 = BenchAppConfs.iterateSize(opts0, 0, 1000, 100)

    // run
    val results = new Runner(opts1.build()).run().asScala
  }

}

object BenchAppConfs {

  val warmup = 3
  val measurement = 5
  val thread = 1
  val fork = 1

  def envOptions(args: List[String]): ChainedOptionsBuilder = {
    val includeO: Option[String] = args.headOption

    val builder0 = new OptionsBuilder()
    val builder1 = builder0.warmupIterations(BenchAppConfs.warmup)
    val builder2 = builder1.measurementIterations(BenchAppConfs.measurement)
    val builder3 = builder2.threads(BenchAppConfs.thread)
    val builder4 = builder3.forks(BenchAppConfs.fork)
    val builder5 = includeO.fold(builder4)(include => builder4.include(include))

    builder5
  }

  def iterateSize(builder: ChainedOptionsBuilder, start: Int, end: Int, by: Int): ChainedOptionsBuilder =
    builder.param("iterateBenchSize", (start to end by by).map(_.toString).toArray: _*)

}
