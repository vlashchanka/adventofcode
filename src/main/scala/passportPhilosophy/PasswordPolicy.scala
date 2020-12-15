package passportPhilosophy

object PasswordPolicy {
  type Min = Int
  type Max = Int
  type Letter = Char
  type Password = String
  type ParsedInstruction = (Min, Max, Letter, Password)


  def toPasswordPolicy(encodedPolicy: String): Either[String, ParsedInstruction] = {
    // Examples:
    // 6-8 f: gmjfrvff
    // 16-18 x: xxxxfxxxgxwxxxxxxsx
    val pattern = "(\\d+)-(\\d+) (\\w): (\\w+)".r

    encodedPolicy match {
      case pattern(min, max, symbol, password) => Right(min.toInt, max.toInt, symbol.head, password)
      case _ => Left(s"Error. Could not parse the password (${encodedPolicy})")
    }
  }

  def isValid(encodedPolicy: String): Boolean = {
    toPasswordPolicy(encodedPolicy) match {
      case Right((min, max, char, password)) =>
        val charCount = password.count(_ == char)
        charCount >= min && charCount <= max
      case _ => false
    }
  }
}
