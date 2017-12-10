package a

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
  HoursPerWeek: String,
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
  HoursPerWeek: String,
  JobSatisfaction: Int,
  JobSecurity: Option[String],
  IDE: Option[String],
  WantWorkLanguage: Option[String]
)

//@JsonCodec
case class JobSatisfactionByHoursPerWeek(
  hoursPerWeek: String,
  jobSatisfactionMean: Double,
  jobSatisfactionStdDev: Double,
  jobSatisfactionTotal: BigInt
)


object StackOverflow {
  implicit val jobSatisfactionByHoursPerWeekEncoder = deriveEncoder[JobSatisfactionByHoursPerWeek]

  def main(args: Array[String]): Unit = {

    val logFile = "/home/damxam/Workspaces/Datasets/survey_results_public.csv"

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Stack Overflow")
      .getOrCreate()

    // With .as[] we get a dataset
    {
      import spark.implicits._

      // Must have case class at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
      val logDataSet: Dataset[Row] = spark.read
        .schema(implicitly[Encoder[StackOverflow]].schema)
        .format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        .option("mode", "DROPMALFORMED")
        .load(logFile)
        .withColumn("IDE", split($"IDE", ";"))
        .cache()

      val filteredDataSet: Dataset[StackOverflowSubset] = logDataSet
        .select("CareerSatisfaction", "DeveloperType", "Gender", "HoursPerWeek", "JobSatisfaction", "JobSecurity", "IDE", "WantWorkLanguage")
        .as[StackOverflowSubset]
        .cache()

      val careerSatisfactionByIde: DataFrame = logDataSet
          .select(explode($"IDE").as("IDE"), $"CareerSatisfaction", $"JobSatisfaction")
          .withColumn("IDE", trim($"IDE"))
          .groupBy($"IDE")
          .agg(mean($"CareerSatisfaction"), mean($"JobSatisfaction"), count($"IDE"))
          .filter("count(IDE) > 20")
          .sort($"avg(JobSatisfaction)")

      val careerSatisfactionByHoursPerWeek: DataFrame = logDataSet
        .filter(not(isnull(round($"HoursPerWeek"))))
        .filter(not($"JobSatisfaction".isin("NA")))
        .select($"HoursPerWeek", $"JobSatisfaction")
        .groupBy($"HoursPerWeek")
        .agg(
          mean("JobSatisfaction"),
          stddev("JobSatisfaction"),
          count("JobSatisfaction")
        )
        .filter("count(JobSatisfaction) >= 10")
        .sort($"avg(JobSatisfaction)")
        .cache()

      val jobSatisfactionCount = logDataSet
        .filter(not(isnull($"JobSatisfaction")))
        .filter(not($"JobSatisfaction".isin("NA")))
        .count()

      val hoursPerWeekCount = logDataSet
        .filter(not(isnull($"HoursPerWeek")))
        .filter(not($"HoursPerWeek".isin("NA")))
        .count()

      val totalCount = logDataSet.count()

      val uniques: immutable.Seq[(String, String)] = List(
        ("CareerSatisfaction", filteredDataSet.map(_.CareerSatisfaction).distinct().take(30).toList.toString),
        ("DeveloperType", filteredDataSet.map(_.DeveloperType).distinct().take(30).toList.toString),
        ("Gender", filteredDataSet.map(_.Gender).distinct().take(30).toList.toString),
        ("HoursPerWeek", filteredDataSet.map(_.HoursPerWeek).distinct().take(30).toList.toString),
        ("JobSatisfaction", filteredDataSet.map(_.JobSatisfaction).distinct().take(30).toList.toString),
        ("JobSecurity", filteredDataSet.map(_.JobSecurity).distinct().take(30).toList.toString),
        ("IDE", filteredDataSet.map(_.IDE).distinct().take(30).toList.toString),
        ("WantWorkLanguage", filteredDataSet.map(_.WantWorkLanguage).distinct().take(30).toList.toString)
      )


      val careerSatisfactionByIdeResult = careerSatisfactionByIde.take(50).map(_.mkString(" ")).toList

      val careerSatisfactionByHoursWorkedResult = careerSatisfactionByHoursPerWeek.take(50).map(_.mkString(" ")).toList

      val counts = List(
        s"Total #                 : $totalCount",
        s"HoursPerWeek #          : $hoursPerWeekCount",
        s"JobSatisfactionCount #  : $jobSatisfactionCount"
      )

      write(
        "./out/results.txt",
        (
          counts ++
          careerSatisfactionByHoursWorkedResult ++
          careerSatisfactionByIdeResult ++
          uniques.map(v => s"${v._1}: ${v._2}")
        ).mkString("\n")
      )

      val csbwJson = careerSatisfactionByHoursPerWeek
        .select(
          $"HoursPerWeek".as("hoursPerWeek"),
          $"avg(JobSatisfaction)".as("jobSatisfactionMean"),
          $"stddev_samp(JobSatisfaction)".as("jobSatisfactionStdDev"),
          $"count(JobSatisfaction)".as("jobSatisfactionTotal")
        )
        .as[JobSatisfactionByHoursPerWeek]
        .collect().toList.asJson

      write("./out/careerSatisfactionByHoursPerWeek.json", csbwJson.spaces2)
    }

    spark.stop()
  }

  def write(dest: String, output: String): Unit = {
    Files.write(
      FileSystems.getDefault.getPath(dest),
      output.getBytes(StandardCharsets.UTF_8)
    )
  }
}
