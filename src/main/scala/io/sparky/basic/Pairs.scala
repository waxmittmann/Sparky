package io.sparky.basic

//import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql._
//import org.apache.spark.
//import spark.

object Pairs {
  def main(args: Array[String]): Unit = {

    val logFile = "/home/damxam/Workspaces/Libraries/spark-2.2.0-bin-hadoop2.7/README.md"

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Simple Application")
      .getOrCreate()

    val logData: Dataset[String] = spark.read.textFile(logFile).cache()
    //spark.

    case class Person(name: String, age: Int, sex: String)
//    case class Person(name: String, age: Int)
//
//    case class Sex(name: String, sex: String)

    import spark.implicits._

    val ds1: RDD[(String, Int)] = spark.createDataset(Seq(
//      Person("thomas", 12),
//      Person("peter", 9),
//      Person("sally", 15)
      ("thomas", 12),
      ("peter", 9),
      ("sally", 15),
      ("thomas", 11)
//    )).rdd.map(p => (p.name, p.age))
    )).rdd

    val ds2: RDD[(String, String)] = spark.createDataset(Seq(
//      Sex("thomas", "m"),
//      Sex("sally", "f")
      ("thomas", "m"),
      ("thomas", "f"),
      ("sally", "f")
    )).rdd//.map(p => (p.name, p.sex))


//    val ds3 = spark.createDataset(List((1, "a"), (2, "b")))
//    val ds3 = spark.createDataset(List((2, "b"), (3, "c")))


    //spark.createDataset(List(1, 2, 3)).groupBy()

//    val ds1 = spark.createDataset(List(
//      ("thomas", 12),
//      ("peter", 9),
//      ("sally", 15)
//    )).rdd
//
//    val ds2 = spark.createDataset(List(
//      ("thomas", "m"),
//      ("sally", "f")
//    )).rdd



    val joined: RDD[(String, (Int, Option[String]))] = ds1.leftOuterJoin(ds2)
    val fullJoined = ds1.join(ds2, 1).map {
      case (name, (age, sex)) => Person(name, age, sex)
    }
//    val joined: RDD[(String, (Int, Option[String]))] = ds1.le

    println(joined.collect().toList)
    println(fullJoined.collect().toList)

    spark.stop()
  }
}
