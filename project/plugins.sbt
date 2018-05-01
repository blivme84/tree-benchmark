resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

// benckmark
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.3.3")
