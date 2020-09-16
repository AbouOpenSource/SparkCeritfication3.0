name := "BasicScala"

version := "0.1"

mainClass := Some("LearningScala1")
scalaVersion := "2.12.11"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.4.0"