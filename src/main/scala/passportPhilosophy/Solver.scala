package passportPhilosophy

import aocd.Problem

object Solver extends Problem(2020, 2) {
  def run(passwords: List[String]): Unit = {
    val correctPasswordsCount = passwords.count(PasswordValidator.isValid)
    println(correctPasswordsCount)
  }
}
