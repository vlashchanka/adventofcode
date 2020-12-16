package passportPhilosophy

object PasswordValidator {
  type Password = String
  type CharMinCount = Int
  type CharMaxCount = Int
  type PasswordWithPolicy = (Password, Char, CharMinCount, CharMaxCount)

  def isValid(encodedPolicy: String): Boolean = {
    toPasswordWithPolicy(encodedPolicy) match {
      case (password, char, min, max) =>
        val charCount = password.count(_ == char)
        charCount >= min && charCount <= max
    }
  }

  def isValidForNewPolicy(encodedPolicy: String): Boolean = {
    toPasswordWithPolicy(encodedPolicy) match {
      case (password, char, charFirstPosition, charSecondPosition) =>
        def isCharInPassword(position: Int): Boolean = password.charAt(position - 1) == char
        List(
          isCharInPassword(charFirstPosition),
          isCharInPassword(charSecondPosition)
        ).count(c => c) == 1
    }
  }

  private def toPasswordWithPolicy(encodedPolicy: String): PasswordWithPolicy = {
    // Examples:
    // 6-8 f: gmjfrvff
    // 16-18 x: xxxxfxxxgxwxxxxxxsx
    val pattern = "(\\d+)-(\\d+) (\\w): (\\w+)".r

    encodedPolicy match {
      case pattern(min, max, symbol, password) => (password, symbol.head, min.toInt, max.toInt)
    }
  }
}
