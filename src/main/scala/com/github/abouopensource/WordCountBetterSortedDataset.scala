package com.github.abouopensource

import org.apache.log4j._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{explode, lower, split}


object WordCountBetterSortedDataset {

  case class Book(value : String)
  def main(args: Array[String]): Unit = {

           Logger.getLogger(WordCountBetterSorted.getClass).setLevel(Level.ERROR)

          val spark = SparkSession.builder()
            .appName("WordCountBetterDataset")
            .master("local[*]")
            .getOrCreate()

    import spark.implicits._

    val inputs = spark.read.text("data/book.txt").as[Book]

    val words = inputs.select(explode(split($"value", "\\W+")).alias("word"))
      .filter($"word" =!= "")

    val lowerCaseWords = words.select(lower($"word").alias("word"))


    val wordCounts = lowerCaseWords.groupBy("word").count()

    wordCounts.show()
  }

}
