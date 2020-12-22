package passportPolicy

import aocd.Problem

import scala.util.matching.Regex

object Solver extends Problem(2020, 4) {
  type Passport = Map[String, String]

  def isValidPassport(passport: Passport): Boolean = {
    val CountryId = "cid"
    val RequiredFieldsCount = 7
    val counted = passport.count({
      case (countryId, _) => countryId != CountryId
    })
    counted == RequiredFieldsCount
  }

  def toPassport(passportFields: String): Passport = {
    val PassportField: Regex = """(\w+):([#\w]+)""".r
    PassportField
      .findAllIn(passportFields)
      .map({ case PassportField(name, value) => name -> value })
      .toMap
  }

  def getValidPassportsCount(lines: List[String]): Int = {
    lines
      .mkString(" ")
      .split("  ")
      .map(toPassport)
      .count(isValidPassport)
  }

  def run(input: List[String]): Unit = {
    val passportsCount = getValidPassportsCount(input)

    println(s"Passports: $passportsCount")
  }
}
