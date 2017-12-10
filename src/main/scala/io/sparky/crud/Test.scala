package io.sparky.crud

object Test {

  def main(args: Array[String]): Unit = {


    val min = 2
    val str = "abcdefghi"

    val result =
      Stream.iterate((str.view, "")) { case (in, out) =>
        val nextRunIndex = in.indexWhere(_ != in.head)
        println("Next run: " + nextRunIndex)
        val newOut =
          if (nextRunIndex >= min)
            out + s"$nextRunIndex${in.head}"
          else
            out + in.view(0, nextRunIndex).mkString
        println("Remaining " + str)
        (str.view(nextRunIndex, in.length-1), newOut)
      }.dropWhile(_._1.nonEmpty)

    println(s"Result: ${result.head._2}")


  }
}
