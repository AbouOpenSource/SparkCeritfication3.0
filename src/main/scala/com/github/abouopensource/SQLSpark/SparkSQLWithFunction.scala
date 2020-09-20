package com.github.abouopensource.SQLSpark
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object SparkSQLWithFunction {
  case class Person(id: Int, name: String,age: Int, friends: Int)

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("SparkSQLDataset")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    val people = spark
      .read
      .option("header", "true")
      .option("inferSchema","true")
      .csv("data/fakefriends.csv")
      .as[Person]

    people.printSchema()

    println("Let's select the name column")
    people.select("name").show()

    println("Filter out anymore over 21")
    people.filter(people("age")<22).show()

    println("Group by age")
    people.groupBy("age").count().show()

    println("Make everyone 10 years older")
    people.select(people("name"), people("age")+10).show()

    spark.stop()


  }

}
