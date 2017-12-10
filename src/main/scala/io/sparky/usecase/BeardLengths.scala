package io.sparky

import org.apache.spark.sql._

// Must be at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
case class BeardLengths(id: Int, name: Option[String], age: Option[Int], beardLengthCm: Option[Int])

case class BeardLengthsProper(id: Int, name: String, age: Int, beardLengthCm: Int)

object BeardLengths {
  def main(args: Array[String]): Unit = {

    val logFile = "/home/damxam/Workspaces/datasets/beardLengths.csv"

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Simple Application")
      .getOrCreate()


    // With .as[] we get a dataset
    {
      import spark.implicits._

      // Must have case class at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
      val logDataSet: Dataset[BeardLengths] = spark.read
        .schema(implicitly[Encoder[BeardLengths]].schema)
        .format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        .option("mode", "DROPMALFORMED")
        .load(logFile)
        .as[BeardLengths]
        .cache()

      val filteredDataSet =
        logDataSet
          .filter(_.beardLengthCm != null)
          .filter(_.age != null)
          .cache()

      import org.apache.spark.sql.functions._
//      val largest: List[BeardLengthsProper] = filteredDataSet.sort(desc("beardLengthCm")).rdd.collect {
//        case BeardLengths(id, Some(name), Some(length), Some(age)) => BeardLengthsProper(id, name, length, age)
//      }.collect().toList
      val largest: List[BeardLengths] = filteredDataSet.filter("beardLengthCm IS NOT null AND name IS NOT NULL").sort(desc("beardLengthCm")).collect().toList

      // Print filtered-out rows
      println(logDataSet.count() + ", " + filteredDataSet.count())

      // Print result
      println(largest.mkString("\n"))
    }

    spark.stop()
  }
}