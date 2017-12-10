package io.sparky.usecase

import java.io.PrintWriter
import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.{FileSystem, FileSystems, Files}

import io.circe.{Encoder => CirceEncoder, _}
import io.circe.syntax._
import io.circe.generic.JsonCodec
import io.circe.generic.semiauto._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._

import scala.collection.immutable
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import org.apache.spark.sql.functions._

// Must be at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
case class StackOverflow(
  Respondent: String,
  Professional: String,
  ProgramHobby: String,
  Country: String,
  University: String,
  EmploymentStatus: String,
  FormalEducation: String,
  MajorUndergrad: String,
  HomeRemote: String,
  CompanySize: String,
  CompanyType: String,
  YearsProgram: String,
  YearsCodedJob: String,
  YearsCodedJobPast: String,
  DeveloperType: String,
  WebDeveloperType: String,
  MobileDeveloperType: String,
  NonDeveloperType: String,
  CareerSatisfaction: Int,
  JobSatisfaction: Int,
  ExCoderReturn: String,
  ExCoderNotForMe: String,
  ExCoderBalance: String,
  ExCoder10Years: String,
  ExCoderBelonged: String,
  ExCoderSkills: String,
  ExCoderWillNotCode: String,
  ExCoderActive: String,
  PronounceGIF: String,
  ProblemSolving: String,
  BuildingThings: String,
  LearningNewTech: String,
  BoringDetails: String,
  JobSecurity: String,
  DiversityImportant: String,
  AnnoyingUI: String,
  FriendsDevelopers: String,
  RightWrongWay: String,
  UnderstandComputers: String,
  SeriousWork: String,
  InvestTimeTools: String,
  WorkPayCare: String,
  KinshipDevelopers: String,
  ChallengeMyself: String,
  CompetePeers: String,
  ChangeWorld: String,
  JobSeekingStatus: String,
  HoursPerWeek: Int,
  LastNewJob: String,
  AssessJobIndustry: String,
  AssessJobRole: String,
  AssessJobExp: String,
  AssessJobDept: String,
  AssessJobTech: String,
  AssessJobProjects: String,
  AssessJobCompensation: String,
  AssessJobOffice: String,
  AssessJobCommute: String,
  AssessJobRemote: String,
  AssessJobLeaders: String,
  AssessJobProfDevel: String,
  AssessJobDiversity: String,
  AssessJobProduct: String,
  AssessJobFinances: String,
  ImportantBenefits: String,
  ClickyKeys: String,
  JobProfile: String,
  ResumePrompted: String,
  LearnedHiring: String,
  ImportantHiringAlgorithms: String,
  ImportantHiringTechExp: String,
  ImportantHiringCommunication: String,
  ImportantHiringOpenSource: String,
  ImportantHiringPMExp: String,
  ImportantHiringCompanies: String,
  ImportantHiringTitles: String,
  ImportantHiringEducation: String,
  ImportantHiringRep: String,
  ImportantHiringGettingThingsDone: String,
  Currency: String,
  Overpaid: String,
  TabsSpaces: String,
  EducationImportant: String,
  EducationTypes: String,
  SelfTaughtTypes: String,
  TimeAfterBootcamp: String,
  CousinEducation: String,
  WorkStart: String,
  HaveWorkedLanguage: String,
  WantWorkLanguage: String,
  HaveWorkedFramework: String,
  WantWorkFramework: String,
  HaveWorkedDatabase: String,
  WantWorkDatabase: String,
  HaveWorkedPlatform: String,
  WantWorkPlatform: String,
  IDE: String,
  AuditoryEnvironment: String,
  Methodology: String,
  VersionControl: String,
  CheckInCode: String,
  ShipIt: String,
  OtherPeoplesCode: String,
  ProjectManagement: String,
  EnjoyDebugging: String,
  InTheZone: String,
  DifficultCommunication: String,
  CollaborateRemote: String,
  MetricAssess: String,
  EquipmentSatisfiedMonitors: String,
  EquipmentSatisfiedCPU: String,
  EquipmentSatisfiedRAM: String,
  EquipmentSatisfiedStorage: String,
  EquipmentSatisfiedRW: String,
  InfluenceInternet: String,
  InfluenceWorkstation: String,
  InfluenceHardware: String,
  InfluenceServers: String,
  InfluenceTechStack: String,
  InfluenceDeptTech: String,
  InfluenceVizTools: String,
  InfluenceDatabase: String,
  InfluenceCloud: String,
  InfluenceConsultants: String,
  InfluenceRecruitment: String,
  InfluenceCommunication: String,
  StackOverflowDescribes: String,
  StackOverflowSatisfaction: String,
  StackOverflowDevices: String,
  StackOverflowFoundAnswer: String,
  StackOverflowCopiedCode: String,
  StackOverflowJobListing: String,
  StackOverflowCompanyPage: String,
  StackOverflowJobSearch: String,
  StackOverflowNewQuestion: String,
  StackOverflowAnswer: String,
  StackOverflowMetaChat: String,
  StackOverflowAdsRelevant: String,
  StackOverflowAdsDistracting: String,
  StackOverflowModeration: String,
  StackOverflowCommunity: String,
  StackOverflowHelpful: String,
  StackOverflowBetter: String,
  StackOverflowWhatDo: String,
  StackOverflowMakeMoney: String,
  Gender: String,
  HighestEducationParents: String,
  Race: String,
  SurveyLong: String,
  QuestionsInteresting: String,
  QuestionsConfusing: String,
  InterestedAnswers: String,
  Salary: String,
  ExpectedSalary: String
)

case class StackOverflowSubset(
  CareerSatisfaction: Int,
  DeveloperType: Option[String],
  Gender: Option[String],
  HoursPerWeek: Int,
  JobSatisfaction: Int,
  JobSecurity: Option[String],
  IDE: Option[String],
  WantWorkLanguage: Option[String],
  Overpaid: String
)

case class JobSatisfactionByHoursPerWeek(
  hoursPerWeek: BigInt,
  jobSatisfactionMean: Double,
  jobSatisfactionStdDev: Double,
  jobSatisfactionTotal: BigInt
)

case class JobSatisfactionByIDE(
  ide: String,
  jobSatisfactionMean: Double,
  jobSatisfactionStdDev: Double,
  jobSatisfactionTotal: BigInt
)

case class JobSatisfactionByGender(
  gender: String,
  jobSatisfactionMean: Double,
  jobSatisfactionStdDev: Double,
  jobSatisfactionTotal: BigInt
)

case class Overpaid(
  overpaid: String,
  count: Long
)

object StackOverflow {
  implicit val jobSatisfactionByIDEEncoder = deriveEncoder[JobSatisfactionByIDE]
  implicit val jobSatisfactionByHoursPerWeekEncoder = deriveEncoder[JobSatisfactionByHoursPerWeek]
  implicit val jobSatisfactionByGenderEncoder = deriveEncoder[JobSatisfactionByGender]
  implicit val overpaidEncoder = deriveEncoder[Overpaid]

  val logFile = "/home/damxam/Workspaces/Datasets/survey_results_public.csv"

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .master("local")
      .appName("Stack Overflow")
      .getOrCreate()

    run(spark)

    spark.stop()
  }

  def run(implicit spark: SparkSession) = {
    val logDataSet = base(logFile)
//    general(logDataSet)
//    jobSatisfaction(logDataSet)
    overpaid(logDataSet)
  }

  def base(path: String)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._

    spark.read
      .schema(implicitly[Encoder[StackOverflow]].schema)
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("mode", "DROPMALFORMED")
      .load(path)
      .withColumn("IDE", split($"IDE", ";"))
      .cache()
  }

  def general(logDataSet: DataFrame)(implicit spark: SparkSession): Unit = {
    import spark.implicits._

    val filteredDataSet: Dataset[StackOverflowSubset] = logDataSet
      .select("CareerSatisfaction", "DeveloperType", "Gender", "HoursPerWeek", "JobSatisfaction", "JobSecurity", "IDE", "WantWorkLanguage", "Overpaid")
      .as[StackOverflowSubset]
      .cache()

    val totalCount = logDataSet.count()
    val jobSatisfactionCount = countValid(logDataSet, $"JobSatisfaction", Some("NA"))
    val hoursPerWeekCount = countValid(logDataSet, $"HoursPerWeek", Some("NA"))

    val uniques: immutable.Seq[(String, String)] = List(
      ("Overpaid", filteredDataSet.map(_.Overpaid).distinct().take(30).toList.toString),
      ("CareerSatisfaction", filteredDataSet.map(_.CareerSatisfaction).distinct().take(30).toList.toString),
      ("DeveloperType", filteredDataSet.map(_.DeveloperType).distinct().take(30).toList.toString),
      ("Gender", filteredDataSet.map(_.Gender).distinct().take(30).toList.toString),
      ("HoursPerWeek", filteredDataSet.map(_.HoursPerWeek).distinct().take(30).toList.toString),
      ("JobSatisfaction", filteredDataSet.map(_.JobSatisfaction).distinct().take(30).toList.toString),
      ("JobSecurity", filteredDataSet.map(_.JobSecurity).distinct().take(30).toList.toString),
      ("IDE", filteredDataSet.map(_.IDE).distinct().take(30).toList.toString),
      ("WantWorkLanguage", filteredDataSet.map(_.WantWorkLanguage).distinct().take(30).toList.toString)
    )

    val counts = List(
      s"Total #                 : $totalCount",
      s"HoursPerWeek #          : $hoursPerWeekCount",
      s"JobSatisfactionCount #  : $jobSatisfactionCount"
    )

    write(
      "./out/results.txt",
      (counts ++ uniques.map(v => s"${v._1}: ${v._2}")).mkString("\n")
    )
  }

  def overpaid(logDataSet: DataFrame)(implicit spark: SparkSession) = {
    //"Neither underpaid nor overpaid, Greatly overpaid, NA, Somewhat overpaid, Somewhat underpaid, Greatly underpaid"

    import spark.implicits._

    val overpaid =
      logDataSet
        .filter(not($"Overpaid".isin("NA")))
        .select("Overpaid")
        .groupBy("Overpaid")
        .count()
        .as[Overpaid]

    write(
      "./out/overpaid.txt",
      overpaid.collect().toList.asJson.spaces2
    )
  }

  def jobSatisfaction(logDataSet: DataFrame)(implicit spark: SparkSession): Unit = {
    import spark.implicits._

    val hasJobSatisfaction = logDataSet.filter(not($"JobSatisfaction".isin("NA"))).cache()

    // By IDE
    val jobSatisfactionByIde: DataFrame = hasJobSatisfaction
      .select(explode($"IDE").as("IDE"), $"JobSatisfaction")
      .withColumn("IDE", trim($"IDE"))
      .groupBy($"IDE")
      .agg(
        mean($"JobSatisfaction"),
        stddev($"JobSatisfaction"),
        count($"JobSatisfaction")
      )
      .filter("count(IDE) > 20")
      .sort($"avg(JobSatisfaction)")
      .cache()

    val byIDEJson = jobSatisfactionByIde
      .select(
        $"IDE".as("ide"),
        $"avg(JobSatisfaction)".as("jobSatisfactionMean"),
        $"stddev_samp(JobSatisfaction)".as("jobSatisfactionStdDev"),
        $"count(JobSatisfaction)".as("jobSatisfactionTotal")
      )
      .as[JobSatisfactionByIDE]
      .collect().toList.asJson

    // By Hours Per Week
    val jobSatisfactionByHoursPerWeek: DataFrame = hasJobSatisfaction
      .filter(not(isnull(round($"HoursPerWeek"))))
      .select($"HoursPerWeek", $"JobSatisfaction")
      .groupBy($"HoursPerWeek")
      .agg(
        mean("JobSatisfaction"),
        stddev("JobSatisfaction"),
        count("JobSatisfaction")
      )
      .filter("count(JobSatisfaction) >= 10")
      .sort($"HoursPerWeek")
      .cache()

    val byHoursJson = jobSatisfactionByHoursPerWeek
      .select(
        $"HoursPerWeek".as("hoursPerWeek"),
        $"avg(JobSatisfaction)".as("jobSatisfactionMean"),
        $"stddev_samp(JobSatisfaction)".as("jobSatisfactionStdDev"),
        $"count(JobSatisfaction)".as("jobSatisfactionTotal")
      )
      .as[JobSatisfactionByHoursPerWeek]
      .collect().toList.asJson

    // By Gender
    val jobSatisfactionByGender: DataFrame = hasJobSatisfaction
      .filter($"Gender".isin("Male", "Female"))
      .groupBy($"Gender")
      .agg(
        mean("JobSatisfaction"),
        stddev("JobSatisfaction"),
        count("JobSatisfaction")
      )
      .filter("count(JobSatisfaction) >= 10")
      .sort($"avg(JobSatisfaction)")
      .cache()

    val byGenderJson = jobSatisfactionByGender
      .select(
        $"Gender".as("gender"),
        $"avg(JobSatisfaction)".as("jobSatisfactionMean"),
        $"stddev_samp(JobSatisfaction)".as("jobSatisfactionStdDev"),
        $"count(JobSatisfaction)".as("jobSatisfactionTotal")
      )
      .as[JobSatisfactionByGender]
      .collect().toList.asJson

    // Write
    write("./out/jobSatisfactionByHoursPerWeek.json", byHoursJson.spaces2)
    write("./out/jobSatisfactionByIdeResult.json", byIDEJson.spaces2)
    write("./out/jobSatisfactionByGender.json", byGenderJson.spaces2)
  }

  def countValid(ds: Dataset[Row], column: Column, exclude: Option[String]): Long = {
    val withoutNulls = ds
      .filter(not(isnull(column)))

    val withoutExclude = exclude
      .map(excludeStr => withoutNulls.filter(not(column.isin(excludeStr)))).getOrElse(withoutNulls)

    withoutExclude.count()
  }

  def write(dest: String, output: String): Unit = {
    Files.write(
      FileSystems.getDefault.getPath(dest),
      output.getBytes(StandardCharsets.UTF_8)
    )
  }
}