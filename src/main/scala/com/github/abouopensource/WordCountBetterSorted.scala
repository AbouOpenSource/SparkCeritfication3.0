package com.github.abouopensource

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object WordCountBetterSorted {
  def main(args: Array[String]): Unit = {
    Logger.getLogger(WordCountBetterSorted.getClass).setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "WordCountBetterSorted")

    val inputs = sc.textFile("data/book.txt")

    val words = inputs.flatMap(x => x.split("\\W+"))

    val lowerCaseWords = words.map(x => x.toLowerCase())

    val wordCounts = lowerCaseWords.map(x=>(x,1)).reduceByKey((x,y)=> x + y )

    val wordCountSorted = wordCounts.map(x => (x._2,x._1)).sortByKey()

    for (result <- wordCountSorted){
      val count = result._1
      val word = result._2
      println(s"$word: $count")
    }

  }

}
