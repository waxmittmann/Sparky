package a

import java.io.File

import com.github.tototoshi.csv._

import scala.collection.immutable

import cats.Semigroup
import cats.implicits._



object SimpleCsvAnalyse {

  def main(args: Array[String]): Unit = {


    val reader = CSVReader.open(new File("/home/damxam/Workspaces/datasets/survey_results_public.csv"))
    val rows: List[List[String]] = reader.iterator.toList.map(_.toList)

    val names =
      List(
        "Respondent","Professional","ProgramHobby","Country","University","EmploymentStatus","FormalEducation",
        "MajorUndergrad","HomeRemote","CompanySize","CompanyType","YearsProgram","YearsCodedJob","YearsCodedJobPast",
        "DeveloperType","WebDeveloperType","MobileDeveloperType","NonDeveloperType","CareerSatisfaction","JobSatisfaction",
        "ExCoderReturn","ExCoderNotForMe","ExCoderBalance","ExCoder10Years","ExCoderBelonged","ExCoderSkills","ExCoderWillNotCode",
        "ExCoderActive","PronounceGIF","ProblemSolving","BuildingThings","LearningNewTech","BoringDetails","JobSecurity",
        "DiversityImportant","AnnoyingUI","FriendsDevelopers","RightWrongWay","UnderstandComputers","SeriousWork",
        "InvestTimeTools","WorkPayCare","KinshipDevelopers","ChallengeMyself","CompetePeers","ChangeWorld","JobSeekingStatus",
        "HoursPerWeek","LastNewJob","AssessJobIndustry","AssessJobRole","AssessJobExp","AssessJobDept","AssessJobTech",
        "AssessJobProjects","AssessJobCompensation","AssessJobOffice","AssessJobCommute","AssessJobRemote","AssessJobLeaders",
        "AssessJobProfDevel","AssessJobDiversity","AssessJobProduct","AssessJobFinances","ImportantBenefits","ClickyKeys",
        "JobProfile","ResumePrompted","LearnedHiring","ImportantHiringAlgorithms","ImportantHiringTechExp",
        "ImportantHiringCommunication","ImportantHiringOpenSource","ImportantHiringPMExp","ImportantHiringCompanies",
        "ImportantHiringTitles","ImportantHiringEducation","ImportantHiringRep","ImportantHiringGettingThingsDone",
        "Currency","Overpaid","TabsSpaces","EducationImportant","EducationTypes","SelfTaughtTypes","TimeAfterBootcamp",
        "CousinEducation","WorkStart","HaveWorkedLanguage","WantWorkLanguage","HaveWorkedFramework","WantWorkFramework",
        "HaveWorkedDatabase","WantWorkDatabase","HaveWorkedPlatform","WantWorkPlatform","IDE","AuditoryEnvironment",
        "Methodology","VersionControl","CheckInCode","ShipIt","OtherPeoplesCode","ProjectManagement","EnjoyDebugging",
        "InTheZone","DifficultCommunication","CollaborateRemote","MetricAssess","EquipmentSatisfiedMonitors","EquipmentSatisfiedCPU",
        "EquipmentSatisfiedRAM","EquipmentSatisfiedStorage","EquipmentSatisfiedRW","InfluenceInternet","InfluenceWorkstation",
        "InfluenceHardware","InfluenceServers","InfluenceTechStack","InfluenceDeptTech","InfluenceVizTools","InfluenceDatabase",
        "InfluenceCloud","InfluenceConsultants","InfluenceRecruitment","InfluenceCommunication","StackOverflowDescribes",
        "StackOverflowSatisfaction","StackOverflowDevices","StackOverflowFoundAnswer","StackOverflowCopiedCode",
        "StackOverflowJobListing","StackOverflowCompanyPage","StackOverflowJobSearch","StackOverflowNewQuestion",
        "StackOverflowAnswer","StackOverflowMetaChat","StackOverflowAdsRelevant","StackOverflowAdsDistracting",
        "StackOverflowModeration","StackOverflowCommunity","StackOverflowHelpful","StackOverflowBetter","StackOverflowWhatDo",
        "StackOverflowMakeMoney","Gender","HighestEducationParents","Race","SurveyLong","QuestionsInteresting","QuestionsConfusing",
        "InterestedAnswers","Salary","ExpectedSalary"
      )


//    val rowMaps: Map[String, List[String]] = rows.map(names.zip(_).toMap).foldLeft(Map.empty) { case (cur, total) =>
//      cur |+| total
//    }

    val rowMaps: Map[String, List[String]] = rows.map(names.zip(_).toMap.mapValues(v => List(v))).reduce(_ |+| _)

    val selectedNames = Set("Professional", "ProgramHobby", "Country", "EmploymentStatus")

    analyse(names, selectedNames, rowMaps)
  }


  def analyse(names: List[String], selectedNames: Set[String], values: Map[String, List[String]]): String = {
    //val selectedIndices = names.zipWithIndex.filter(v => selectedNames.contains(v._1)).map(_._2)
    val selectedValues = values.filter(v => selectedNames.contains(v._1))
    val res = selectedValues.mapValues(_.distinct).toList
    res.mkString("\n")
  }

}
