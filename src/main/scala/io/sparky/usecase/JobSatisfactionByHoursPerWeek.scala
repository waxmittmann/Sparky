package io.sparky.usecase

case class JobSatisfactionByHoursPerWeek(
  hoursPerWeek: String,
  jobSatisfactionMean: Double,
  jobSatisfactionStdDev: Double,
  jobSatisfactionTotal: BigInt
)
