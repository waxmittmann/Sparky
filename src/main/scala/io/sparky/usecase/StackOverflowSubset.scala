package io.sparky.usecase

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
