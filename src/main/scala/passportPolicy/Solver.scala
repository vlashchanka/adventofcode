package passportPolicy

import aocd.Problem

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

  def getValidPassportsCount(lines: List[String]): Int = {
    val PassportField = """(\w+):([#\w]+)""".r
    lines
      .mkString(" ")
      .split("  ")
      .map(passportFields =>
        (PassportField findAllIn passportFields)
          .map({ case PassportField(name, value) => name -> value })
          .toMap
      )
      .count(isValidPassport)
  }

  def run(input: List[String]): Unit = {
    val passportsCount = getValidPassportsCount(input)

    println(s"Passports: $passportsCount")
  }
}
