package passportPolicy

import aocd.Problem

import scala.annotation.tailrec

object Solver extends Problem(2020, 4) {
  type PassportFields = Map[String, String]
  def getValidPassportsCount(lines: List[String]): Int = {
    val pattern = "(\\w+):([#\\w]+)".r

    val CountryId = "cid"
    val RequiredFieldsCount = 7

    def isValidPassport(passport: PassportFields): Boolean = {
      val counted = passport.count(c => c._1 != CountryId)
      counted == RequiredFieldsCount
    }

    @tailrec
    def combinePassports(lines: List[String], passports: Int = 0, currentPassport: PassportFields): Int = {
      def countPassports: Int = {
        if (isValidPassport(currentPassport)) passports + 1 else passports
      }

      if (lines.isEmpty) {
        countPassports
      } else {
        if (lines.head.isEmpty) {
          combinePassports(lines.tail, countPassports, Map())
        } else {
          val updatedPassport = pattern.findAllIn(lines.head).matchData
            .foldLeft(currentPassport)(
              (pass, matches) => {
                val key = matches.group(1)
                val value = matches.group(2)
                pass + (key -> value)
              }
            )
          combinePassports(lines.tail, passports, updatedPassport)
        }
      }
    }

    combinePassports(lines, 0, Map())
  }

  def run(input: List[String]): Unit = {
    val passportsCount = getValidPassportsCount(input)

    println(s"Passports: $passportsCount")
  }
}
