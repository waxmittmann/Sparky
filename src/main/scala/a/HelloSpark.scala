package a

//import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql._

object HelloSpark {
  def main(args: Array[String]): Unit = {

    val logFile = "/home/damxam/Workspaces/Libraries/spark-2.2.0-bin-hadoop2.7/README.md"

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Simple Application")
      .getOrCreate()

    //.setMaster("local[2]").set("spark.executor.memory","1g");

    val logData: Dataset[String] = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()


    val r =
      logData.rdd
        .map(w => w.replaceAll(",", ""))
        .flatMap(_.split(" "))
        .map(w => (w, 1))
        .reduceByKey(_ + _)

    val wordTotals = r.sortBy(_._2).collect()



    //val rdd: Dataset[String] = spark.read.textFile(logFile)

    println(s"Lines with a: $numAs, Lines with b: $numBs, ${wordTotals.toList.mkString("\n")}")
    spark.stop()
  }
}
