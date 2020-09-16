package com.github.abouopensource

import org.apache.spark._
import org.apache.log4j._
object RatingsCounter {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR);


    val sc = new SparkContext("local[*]","RatingCounter")

    val lines = sc.textFile("ml-100k/u.data")

    //lines.foreach(println)

    val ratings = lines.map(x => x.split("\t")(2))

    val results = ratings.countByValue()

    val sortedResults = results.toSeq.sortBy(_._1)

    sortedResults.foreach(println)



  }
}
