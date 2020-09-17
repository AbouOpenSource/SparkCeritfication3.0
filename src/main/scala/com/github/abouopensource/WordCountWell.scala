package com.github.abouopensource

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object WordCountWell {
  def main(args: Array[String]): Unit = {
    Logger.getLogger(WordCountWell.getClass).setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","WordCountWell")

    val input = sc.textFile("data/book.txt")

    val words = input.flatMap(x => x.split("\\W+"))

    val lowerCaseWords = words.map(x=>x.toLowerCase)

    val countByWord = lowerCaseWords.countByValue()

    countByWord.foreach(println)
  }

}
