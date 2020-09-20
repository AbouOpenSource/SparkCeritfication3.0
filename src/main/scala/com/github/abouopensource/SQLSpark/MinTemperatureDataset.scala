package com.github.abouopensource.SQLSpark



import breeze.linalg.Vector.castOps
import breeze.numerics.round
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{FloatType, IntegerType, StringType, StructType}
import org.apache.spark._
object MinTemperatureDataset {

  case class Temperature(stationID: String, date: Int, measure_type: String, temperature: Float)
  def main(args: Array[String]): Unit = {
    Logger.getLogger(MinTemperatureDataset.getClass).setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("MinTemperatures")
      .master("local[*]")
      .getOrCreate()

    val temperatureSchema = new StructType()
      .add("stationID", StringType, nullable = true)
      .add("date", IntegerType, nullable = true)
      .add("measure_type", StringType, nullable = true)
      .add("temperature", FloatType, nullable=true)

    import spark.implicits._
    val ds = spark.read
      .schema(temperatureSchema)
      .csv("data/1800.csv")
      .as[Temperature]

    val minTemps = ds.filter($"measure_type"==="TMIN")

    val stationTemps = minTemps.select("stationID","temperature")

    val minTempsByStation = stationTemps.groupBy("stationID").min("temperature")

    val minTempsByStationF = minTempsByStation.withColumn("temperature",$"min(temperature)")
        .select("stationID", "temperature")
       .sort("temperature")

    val results = minTempsByStationF.collect()

    for (result <- results){
      val station = result(0)
      val temp = result(1).asInstanceOf[Float]


      println(s"StationID : $station Temperature Min : $temp")
    }
  }
    }
