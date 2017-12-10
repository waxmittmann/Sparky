package io.sparky

import org.apache.spark.sql._

case class DeviceIoTData (battery_level: Long, c02_level: Long, cca2: String, cca3: String, cn: String, device_id: Long, device_name: String, humidity: Long, ip: String, latitude: Double, lcd: String, longitude: Double, scale:String, temp: Long, timestamp: Long)

object DataSets {

  def main(args: Array[String]): Unit = {

    val logFile = "/home/damxam/Workspaces/Libraries/spark-2.2.0-bin-hadoop2.7/README.md"

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Simple Application")
      .getOrCreate()

    import spark.implicits._

    val ds: Dataset[DeviceIoTData] = spark.read.json("./data/test.json").as[DeviceIoTData]

    ds.createGlobalTempView("test")

    val r1 = ds.map(ds => s"${ds.latitude}, ${ds.longitude}")
    val r2 = r1.collect()

    println(r2)


//    val r1b = ds.selectExpr("SELECT latitude")
//    val r2b = r1b.collect()
//    println(r2b)

    val r1b = spark.sqlContext.sql("SELECT * FROM global_temp.test").collect()
    println(r1b)

    spark.stop()


  }


}
