package com.github.abouopensource

import java.util.logging.{Level, Logger}

object HelloWorld {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.CONFIG);
   // val sc = new SparkContext("local[*]","HelloWorld");

  }
}
