package a

import java.nio.charset.Charset
import java.nio.file.{FileSystem, FileSystems, Files}

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

import scala.collection.immutable
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

// Must be at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
//case class StackOverflow(id: Int, name: Option[String], age: Option[Int], beardLengthCm: Option[Int])
//case class BeardLengthsProper(id: Int, name: String, age: Int, beardLengthCm: Int)


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
//  JobSatisfaction: Option[Int],
  JobSatisfaction: Int,
  JobSecurity: Option[String],
  IDE: Option[String],
  WantWorkLanguage: Option[String]
)

object StackOverflow {
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
        //ta.withColumn("D", split($"A", "\\.")(0)).show(false)
//        .withColumn("IDE", split($"IDE", ";")(0)) //.show(false)
        .withColumn("IDE", split($"IDE", ";")) //.show(false)
        .filter(not(isnull(round($"HoursPerWeek"))))
        .filter(not($"CareerSatisfaction".isin("NA")))
        .filter(not($"JobSatisfaction".isin("NA")))
        .cache()
//        .filter($"CareerSatisfaction".
//        .withColumn("HoursPerWeek", map($"HoursPerWeek"))
//        .withColumn("HoursPerWeek", format_number($"HoursPerWeek", 0))


      val filteredDataSet: Dataset[StackOverflowSubset] = logDataSet
        .select("CareerSatisfaction", "DeveloperType", "Gender", "HoursPerWeek", "JobSatisfaction", "JobSecurity", "IDE", "WantWorkLanguage")
        .as[StackOverflowSubset]
        .cache()

      val answers: DataFrame = logDataSet
          .select(explode($"IDE").as("IDE"), $"CareerSatisfaction")
          //.select(grouping($"IDE"))
          //.select(grouping($"IDE"), mean($"CareerSatisfaction"))
          //.groupBy("IDE")
          .groupBy($"IDE")
          .mean("CareerSatisfaction")
          //.select($"IDE, COUNT(CareerSatisfaction")
          //.select(mean($"CareerSatisfaction"))
          //.select("IDE", "CareerSatisfaction")
//        .withColumn("SatisfactionByIDE", expr(""))
//        .selectExpr("SELECT CareerSatisfaction, ")

//      val filteredDataSet = logDataSet.cache()

      import org.apache.spark.sql.functions._

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


      val answersStr = answers.take(50).map(_.mkString(" ")).toList
      Files.write(FileSystems.getDefault.getPath("./results.txt"), (answersStr ++ uniques.map(v => s"${v._1}: ${v._2}")).asJava, Charset.defaultCharset())


      //      val uniques: immutable.Seq[(String, String)] = List(
//        ("CareerSatisfaction", filteredDataSet.map(_.CareerSatisfaction).distinct().take(30).toList.toString),
//        ("AssessJobExp", filteredDataSet.map(_.AssessJobExp).distinct().take(30).toList.toString),
//        ("BuildingThings", filteredDataSet.map(_.BuildingThings).distinct().take(30).toList.toString),
//        ("ChallengeMyself", filteredDataSet.map(_.ChallengeMyself).distinct().take(30).toList.toString),
//        ("ChangeWorld", filteredDataSet.map(_.ChangeWorld).distinct().take(30).toList.toString),
//        ("CompanySize", filteredDataSet.map(_.CompanySize).distinct().take(30).toList.toString),
//        ("CompanyType", filteredDataSet.map(_.CompanyType).distinct().take(30).toList.toString),
//        ("CompetePeers", filteredDataSet.map(_.CompetePeers).distinct().take(30).toList.toString),
//        ("DeveloperType", filteredDataSet.map(_.DeveloperType).distinct().take(30).toList.toString),
//        ("DiversityImportant", filteredDataSet.map(_.DiversityImportant).distinct().take(30).toList.toString),
//        ("EducationImportant", filteredDataSet.map(_.EducationImportant).distinct().take(30).toList.toString),
//        ("EducationTypes", filteredDataSet.map(_.EducationTypes).distinct().take(30).toList.toString),
//        ("EmploymentStatus", filteredDataSet.map(_.EmploymentStatus).distinct().take(30).toList.toString),
//        ("EnjoyDebugging", filteredDataSet.map(_.EnjoyDebugging).distinct().take(30).toList.toString),
//        ("Gender", filteredDataSet.map(_.Gender).distinct().take(30).toList.toString),
//        ("HaveWorkedDatabase", filteredDataSet.map(_.HaveWorkedDatabase).distinct().take(30).toList.toString),
//        ("HaveWorkedLanguage", filteredDataSet.map(_.HaveWorkedLanguage).distinct().take(30).toList.toString),
//        ("HaveWorkedPlatform", filteredDataSet.map(_.HaveWorkedPlatform).distinct().take(30).toList.toString),
//        ("HaveWorkedFramework", filteredDataSet.map(_.HaveWorkedFramework).distinct().take(30).toList.toString),
//        ("HoursPerWeek", filteredDataSet.map(_.HoursPerWeek).distinct().take(30).toList.toString),
//        ("JobSatisfaction", filteredDataSet.map(_.JobSatisfaction).distinct().take(30).toList.toString),
//        ("JobSecurity", filteredDataSet.map(_.JobSecurity).distinct().take(30).toList.toString),
//        ("IDE", filteredDataSet.map(_.IDE).distinct().take(30).toList.toString),
//        ("WantWorkLanguage", filteredDataSet.map(_.WantWorkLanguage).distinct().take(30).toList.toString)
//      )


      println("\n\n\nAnswers:")
      println(answers.take(50).map(_.mkString(" ")).mkString("\n"))

      println("\n\n\nUniques:")
      println(uniques.map((v: (String, String)) => s"${v._1}: ${v._2}").mkString("\n"))
//
//      val largest: List[StackOverflow] = filteredDataSet.take(10).toList
//
//      // Print filtered-out rows
//      println(logDataSet.count() + ", " + filteredDataSet.count())
//
//      // Print result
//      println(largest.mkString("\n"))
    }

    spark.stop()
  }
}
