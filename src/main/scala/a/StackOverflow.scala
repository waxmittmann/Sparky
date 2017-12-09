package a

import org.apache.spark.sql._

import scala.collection.immutable

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
  CareerSatisfaction: String,
  JobSatisfaction: String,
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


object StackOverflow {
  def main(args: Array[String]): Unit = {

    val logFile = "/home/damxam/Workspaces/datasets/survey_results_public.csv"

    val spark = SparkSession
      .builder
      .master("local")
      .appName("Stack Overflow")
      .getOrCreate()


    // With .as[] we get a dataset
    {
      import spark.implicits._

      // Must have case class at top level, else will get a type tag not found which fails implicit case class Encoder derivation!
      val logDataSet: Dataset[StackOverflow] = spark.read
        .schema(implicitly[Encoder[StackOverflow]].schema)
        .format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        .option("mode", "DROPMALFORMED")
        .load(logFile)
        .as[StackOverflow]
        .cache()

      val filteredDataSet =
        logDataSet.cache()

      import org.apache.spark.sql.functions._
//      val largest: List[BeardLengthsProper] = filteredDataSet.sort(desc("beardLengthCm")).rdd.collect {
//        case BeardLengths(id, Some(name), Some(length), Some(age)) => BeardLengthsProper(id, name, length, age)
//      }.collect().toList


      val uniques: immutable.Seq[(String, String)] = List(
        ("CareerSatisfaction", filteredDataSet.map(_.CareerSatisfaction).distinct().take(30).toList.toString),
        ("AssessJobExp", filteredDataSet.map(_.AssessJobExp).distinct().take(30).toList.toString),
        ("BuildingThings", filteredDataSet.map(_.BuildingThings).distinct().take(30).toList.toString),
        ("ChallengeMyself", filteredDataSet.map(_.ChallengeMyself).distinct().take(30).toList.toString),
        ("ChangeWorld", filteredDataSet.map(_.ChangeWorld).distinct().take(30).toList.toString),
        ("CompanySize", filteredDataSet.map(_.CompanySize).distinct().take(30).toList.toString),
        ("CompanyType", filteredDataSet.map(_.CompanyType).distinct().take(30).toList.toString),
        ("CompetePeers", filteredDataSet.map(_.CompetePeers).distinct().take(30).toList.toString),
        ("DeveloperType", filteredDataSet.map(_.DeveloperType).distinct().take(30).toList.toString),
        ("DiversityImportant", filteredDataSet.map(_.DiversityImportant).distinct().take(30).toList.toString),
        ("EducationImportant", filteredDataSet.map(_.EducationImportant).distinct().take(30).toList.toString),
        ("EducationTypes", filteredDataSet.map(_.EducationTypes).distinct().take(30).toList.toString),
        ("EmploymentStatus", filteredDataSet.map(_.EmploymentStatus).distinct().take(30).toList.toString),
        ("EnjoyDebugging", filteredDataSet.map(_.EnjoyDebugging).distinct().take(30).toList.toString),
        ("Gender", filteredDataSet.map(_.Gender).distinct().take(30).toList.toString),
        ("HaveWorkedDatabase", filteredDataSet.map(_.HaveWorkedDatabase).distinct().take(30).toList.toString),
        ("HaveWorkedLanguage", filteredDataSet.map(_.HaveWorkedLanguage).distinct().take(30).toList.toString),
        ("HaveWorkedPlatform", filteredDataSet.map(_.HaveWorkedPlatform).distinct().take(30).toList.toString),
        ("HaveWorkedFramework", filteredDataSet.map(_.HaveWorkedFramework).distinct().take(30).toList.toString),
        ("HoursPerWeek", filteredDataSet.map(_.HoursPerWeek).distinct().take(30).toList.toString),
        ("JobSatisfaction", filteredDataSet.map(_.JobSatisfaction).distinct().take(30).toList.toString),
        ("JobSecurity", filteredDataSet.map(_.JobSecurity).distinct().take(30).toList.toString),
        ("IDE", filteredDataSet.map(_.IDE).distinct().take(30).toList.toString),
        ("WantWorkLanguage", filteredDataSet.map(_.WantWorkLanguage).distinct().take(30).toList.toString)
      )

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
