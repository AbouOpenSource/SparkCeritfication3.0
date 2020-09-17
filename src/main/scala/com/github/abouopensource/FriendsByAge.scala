package com.github.abouopensource
import org.apache.spark._
import org.apache.log4j._

object FriendsByAge {
  def parseLine(value: String):(Int, Int) ={
    val fields = value.split(",")
    val age = fields(2).toInt
    val numberFriends = fields(3).toInt
    (age, numberFriends)
  }

  def main(args: Array[String]): Unit = {

    Logger.getLogger(FriendsByAge.getClass).setLevel(Level.ERROR)

    println(FriendsByAge.getClass)
    val sc = new SparkContext("local[*]","FriendsByAge")

    val lines = sc.textFile("data/fakefriends-noheader.csv")

    val rdd = lines.map(parseLine)

    val totalByAge = rdd.mapValues(x => (x,1)).reduceByKey((x,y) => (x._1 + y._1, x._2 + y._2))

    val averageByAge = totalByAge.mapValues(x => x._1/x._2)

    val results = averageByAge.collect()

    results.sorted.foreach(println)
  }
}
