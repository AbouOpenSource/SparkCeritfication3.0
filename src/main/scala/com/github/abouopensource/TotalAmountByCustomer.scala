package com.github.abouopensource

import org.apache.log4j._
import org.apache.spark.SparkContext

object TotalAmountByCustomer {
  def parsingData(value: String)={
    val fields = value.split(",")
    val customerId = fields(0).toInt
    val amount = fields(2).toFloat
    (customerId, amount)

  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger(TotalAmountByCustomer.getClass).setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "TotalAmountByCustomer")

    val inputs = sc.textFile("data/customer-orders.csv")

    val custIdAmount = inputs.map(x => parsingData(x))

    val reucedvalueByCustomer = custIdAmount.reduceByKey((x, y)=> x + y )

     val forSorted = reucedvalueByCustomer.map(x => (x._2,x._1))

    val sortedData = forSorted.sortByKey()

    sortedData.collect().foreach(println)


  }

}
