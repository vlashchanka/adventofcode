package passportPolicy

import aocd.Problem

import scala.annotation.tailrec

object Solver extends Problem(2020, 4) {
  type Passport = Map[String, String]

  def newPassport(): Passport = {
    Map()
  }

  def getValidPassportsCount(lines: List[String]): Int = {
    val fieldsExtractor = """(\w+):([#\w]+)""".r

    val CountryId = "cid"
    val RequiredFieldsCount = 7

    def isValidPassport(passport: Passport): Boolean = {
      val counted = passport.count({
        case (countryId, _) => countryId != CountryId
        case _ => false
      })
      counted == RequiredFieldsCount
    }

    @tailrec
    def combinePassports(lines: List[String], passports: Int = 0, currentPassport: Passport): Int = {
      def countPassports: Int = {
        passports + (if (isValidPassport(currentPassport)) 1 else 0)
      }
      lines match {
        case Nil => countPassports
        case head :: tail =>
          head match {
            case "" => combinePassports(tail, countPassports, newPassport())
            case _ =>
              combinePassports(tail, passports, (fieldsExtractor findAllIn head)
                .map({ case fieldsExtractor(key, value) => key -> value })
                .toMap ++ currentPassport
              )
          }
      }
    }

    combinePassports(lines, 0, newPassport())
  }

  def run(input: List[String]): Unit = {
    val passportsCount = getValidPassportsCount(input)

    println(s"Passports: $passportsCount")
  }
}
