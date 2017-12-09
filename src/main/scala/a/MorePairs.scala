package a

import org.apache.spark._
import org.apache.spark.sql._

object MorePairs extends App {

  val spark = SparkSession
    .builder
    .master("local")
    .appName("Simple Application")
    .getOrCreate()

  import spark.implicits._

  val ds: Dataset[(String, Int)] =
    spark.createDataset(List(
      ("a", 1),
      ("b", 2),
      ("c", 3),
      ("d", 4),
      ("c", 3),
      ("e", 5),
      ("a", 2)
    ))

  val r = ds.rdd.combineByKey[Int](
    createCombiner = (a: Int) => a,
    mergeValue = (_: Int) + (_: Int),
    mergeCombiners = (_: Int) + (_: Int)
  )

  println(r.collectAsMap())

}
