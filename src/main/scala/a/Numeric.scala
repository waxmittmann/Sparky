package a

import org.apache.spark.sql._
import org.apache.spark._

object Numeric {

//  implicit def between[S](v: Numeric[S], v2: Numeric[S])(tv: Numeric[S]): Boolean = {
//    if ()
//  }

//  def foo[T](x: T)(implicit n: Numeric[T]) = n.toDouble(x)
//  def foo[T : Numeric](x: T) = implicitly[Numeric[T]].toDouble(x)

  implicit def between[T](x: T, x2: T)(xt: T)(implicit n: Numeric[T]): Boolean = {
    val (l, u) =
      if    (n.lt(x, x2)) (x, x2)
      else  (x2, x)

    n.lt(l, xt) && n.gt(u, xt)
  }

  def foo[T : Numeric](x: T) = implicitly[Numeric[T]].toDouble(x)


  def main(args: Array[String]): Unit = {

//    between(0.5, 4.0)

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Simple Application")
      .getOrCreate()

    import spark.implicits._

    val ds: Dataset[Double] = spark.createDataset(List(1.5, 1.0, 2.5, 8.5, 2.0, 2.0, 3.0))

    println("Debug: " + ds.rdd.toDebugString)

    println(ds.rdd.mean())
    //println(ds.rdd.filter(v => v >= 0.5 && v <= 4.0).mean())
    println(ds.rdd.filter(v => between(0.5, 4.0)(v)).mean())
    println(ds.rdd.filter(between(0.5, 4.0) _).mean())
    println(ds.rdd.filter(between(0.5, 4.0)).mean())
  }

}
