
name := "scala-stm"

organization := "org.scala-stm"

version := "0.8-BoostingFriendly"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.12.0")

javacOptions in (Compile, compile) ++= {
  val javaVersion = if (scalaVersion.value.startsWith("2.11")) "1.6" else "1.8"
  Seq("-source", javaVersion, "-target", javaVersion)
}

libraryDependencies += ("org.scalatest" %% "scalatest" % "3.0.1" % "test")

libraryDependencies += ("junit" % "junit" % "4.12" % "test")

// skip exhaustive tests
testOptions += Tests.Argument("-l", "slow")

// test of TxnExecutor.transformDefault must be run by itself
parallelExecution in Test := false

