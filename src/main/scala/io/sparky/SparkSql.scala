package io.sparky

import org.apache.spark.sql.SparkSession

object SparkSql {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder
      .master("local")
      .enableHiveSupport()
      .appName("Simple Application")
      .getOrCreate()

    spark.sql("DROP TABLE cheeses")

    spark.sql(
      """CREATE TABLE cheeses (
        | id BIGINT,
        | name STRING
        |)""".stripMargin)

    spark.sql("INSERT INTO cheeses VALUES (0, 'camenbert'), (1, 'emmenthaler')")
    //spark.sql("INSERT INTO cheeses VALUES 1, 'emmenthaler'")

    println(spark.sql("SELECT * FROM cheeses").persist().collect().toList)
    println(spark.sql("SELECT * FROM cheeses").collect().map(_.getAs[String]("name")).toList)

  }

}
