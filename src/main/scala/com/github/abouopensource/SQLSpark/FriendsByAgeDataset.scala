package com.github.abouopensource.SQLSpark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{avg, round}


object FriendsByAgeDataset {
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
    val ageAndFriends = people.select("age", "friends")

    people.groupBy("age").avg("friends").sort("age").show()

    ageAndFriends.groupBy("age").agg(round(avg("friends"),2)).sort("age").show()

    ageAndFriends.groupBy("age").agg(round(avg("friends"),2)
      .alias("friends_avg"))
      .sort("age")
      .show()


  }
}
