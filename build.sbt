name := "pbt"

version := "1.0"

resolvers ++= Seq(
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.6",
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test",
  "net.debasishg" %% "redisclient" % "2.13"
)