name := "LearningSpark"

version := "0.1"

scalaVersion := "2.11.8"

val sparkVersion = "2.2.0"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
//  "org.typelevel" %% "cats-core" % "1.0.0-MF",
//  "org.typelevel" %% "cats" % "1.0.0-MF",
  "org.typelevel" %% "cats" % "0.9.0",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "com.github.tototoshi" %% "scala-csv" % "1.3.5"
  //"org.typelevel" %% "cats-core" % "1.0.0-RC1"
)




//run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))