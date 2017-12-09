name := "LearningSpark"

version := "0.1"

scalaVersion := "2.11.8"

//libraryDependencies ++= Seq(
//  "org.typelevel" %% "cats-core" % "1.0.0-MF",
//  "org.apache.spark" %% "spark-core" % "2.2.0" % "provided",
//  "org.apache.spark" %% "spark-sql" % "2.2.0"
//)


val sparkVersion = "2.2.0"


resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.0.0-MF",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion
)




//run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))