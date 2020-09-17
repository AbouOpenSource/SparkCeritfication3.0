package com.github.abouopensource

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object WordCount {
  def main(args: Array[String]): Unit = {
    Logger.getLogger(WordCount.getClass).setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]","WordCount")

    val input = sc.textFile("data/book.txt")

    val words = input.flatMap(x => x.split(" "))

  //  words.foreach(println)

    val wordCount = words.countByValue()

    wordCount.foreach(println)
  }
}
