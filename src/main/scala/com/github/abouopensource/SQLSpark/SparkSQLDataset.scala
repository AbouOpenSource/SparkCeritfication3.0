package com.github.abouopensource.SQLSpark
import org.apache.spark.sql._
import org.apache.log4j._
object SparkSQLDataset extends App {
  case class Person(id: Int, name: String,age: Int, friends: Int)

  override def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("SparkSQLDataset")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    val schemaPeople = spark
                    .read
                    .option("header", "true")
                    .option("inferSchema","true")
                    .csv("data/fakefriends.csv")
                    .as[Person]

    schemaPeople.printSchema()

    schemaPeople.createOrReplaceTempView("people")

    val teenagers = spark.sql("SELECT * FROM people WHERE age >= 13 AND age <= 19")

    val results = teenagers.collect()

    results.foreach(println)

    spark.stop()

  }
}
