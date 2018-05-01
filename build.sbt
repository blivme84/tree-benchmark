
name := "tree-benchmark"

version := "0.1"

scalaVersion := "2.12.6"

enablePlugins(JmhPlugin)
mainClass in (Jmh, run) := Some("benchmark.tree.BenchApp")
