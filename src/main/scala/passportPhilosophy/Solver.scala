package passportPhilosophy

import aocd.Problem

object Solver extends Problem(2020, 2) {
  def run(passwords: List[String]): Unit = {
    val correctPasswords = passwords.count(PasswordValidator.isValid)
    println(s"Correct passwords: ${correctPasswords}")
    val correctPasswordsForNewPolicy = passwords.count(PasswordValidator.isValidForNewPolicy)
    println(s"Correct passwords for new policy: ${correctPasswordsForNewPolicy}")
  }
}
