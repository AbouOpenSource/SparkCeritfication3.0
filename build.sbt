name := "BasicScala"

version := "0.1"

mainClass := Some("LearningScala1")

scalaVersion := "2.13.3"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.4" % "provided"
)
