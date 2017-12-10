package io.sparky.usecase

//import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql._

import scala.util.Try

// Must be at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
case class FakeNews(
  uuid: String,
  ord_in_thread: String,
  author: String,
  published: String,
  title: String,
  text: String,
  language: String,
  crawled: String,
  site_url: String,
  country: String,
  domain_rank: String,
  thread_title: String,
  spam_score: Option[Double],
  main_img_url: String,
  replies_count: Option[Int],
  participants_count: Option[Int],
  likes: Option[Int],
  comments: String,
  shares: Option[Int],
  `type`: String
)

object FakeNews {
  def main(args: Array[String]): Unit = {

    val logFile = "/home/damxam/Workspaces/datasets/fake.csv"

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Simple Application")
      .getOrCreate()


    // Do some diagnosing of bad data
    {
      val logDataFrame: DataFrame = spark.read
        .format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        .load(logFile).cache()

      val bad = logDataFrame.select("spam_score")
        .filter(v => Try(v.getAs[String](0).toInt).isFailure)
        .take(20).map(_.getString(0))

      println(bad.toList.mkString("\n"))
    }



    // Cols:
    //"uuid","ord_in_thread","author","published","title","text","language","crawled","site_url","country","domain_rank",
    // "thread_title","spam_score","main_img_url","replies_count","participants_count","likes","comments","shares","type"

    // This will get us a dataframe (.read.format(...) is to read data frames). But those are untyped.
    {
      val logDataFrame: DataFrame = spark.read
        .format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        .load(logFile).cache()

//      val subset: DataFrame = logDataFrame.select("title", "spam_score", "likes", "shares").cache()
//      val largest: Array[Row] = subset.sort("likes").take(20)
      val largest: Array[Row] = logDataFrame.sort("likes").take(20)
      val processed = largest
//        .map(_.getValuesMap(
//          List("uuid","ord_in_thread","author","published","title","text","language","crawled","site_url","country","domain_rank",
//             "thread_title","spam_score","main_img_url","replies_count","participants_count","likes","comments","shares","type")
//        ))
        .map(_.mkString("|")).toList.mkString("\n")

      println(processed)
    }

    // With .as[] we get a dataset
    {
      import spark.implicits._

      // Must have case class at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
      //implicit val pe = newProductEncoder[FakeNews]
      //implicitly[Encoder[FakeNews]]

      //val logDataSet: Dataset[FakeNews] = spark.read.csv(logFile).as[FakeNews].cache()
      val logDataSet: Dataset[FakeNews] = spark.read
        .schema(implicitly[Encoder[FakeNews]].schema)
        .format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        //.option("delimiter", "\t")
        .load(logFile)
        //.csv(logFile) // Hmm, this won't read the headers in the csv :/
        .as[FakeNews]
        .cache()

      val filteredDataSet =
        logDataSet
          .filter(_.title != null)
          .filter(_.country != null)
          .cache()

      import org.apache.spark.sql.functions._
      val largest: Array[FakeNews] = filteredDataSet.sort(desc("likes")).distinct().take(20)
      // Print filtered-out rows
      println(logDataSet.count() + ", " + filteredDataSet.count())

      // Print result
      println(largest.toList.mkString("\n"))
      //println(largest.toList.map(fn => (fn.title.take(20), fn.country, fn.comments, fn.likes.getOrElse(0), fn.shares.getOrElse(0), fn.spam_score.getOrElse(0))).mkString("\n"))
    }


    spark.stop()
  }
}
