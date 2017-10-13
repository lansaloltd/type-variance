name := "type-variance"

organization := "LansaloLtd"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.3"

crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "junit" % "junit" % "4.8.1" % "test"
)



