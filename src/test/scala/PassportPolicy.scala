import org.scalatest.FunSuite
import org.scalatest.Matchers.convertToAnyShouldWrapper
import passportPolicy.Solver

import scala.io.Source

class PassportPolicy extends FunSuite {
  test("should countvalid passports") {
    val list = Source.fromResource("04.example.txt").getLines().toList
    Solver.getValidPassportsCount(list) shouldBe 2
  }
}