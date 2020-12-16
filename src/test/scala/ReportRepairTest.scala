import org.scalatest.FunSuite
import reportRepair.ReportRepairSolver

class ReportRepairTest extends FunSuite {
  test("ReportRepairSolver - should return correct number") {
    val codes = List(1, 4, 45, 6, 10, 8)
    val sum = 16
    val expected = Right(10, 6)
    val actual = ReportRepairSolver.getNumbersEqualToSum(sum, codes)
    assert(actual === expected)
  }

  test("ReportRepairSolver - should return error") {
    val codes = List(1, 4, 45, 6, 10, 8)
    val sum = 3
    val expected = Left("Pair to have sum 3 was not found")
    val actual = ReportRepairSolver.getNumbersEqualToSum(sum, codes)
    assert(actual === expected)
  }

  test("ReportRepairSolver - should return correct number for three numbers") {
    val codes = List(1, 4, 45, 6, 10, 8)
    val sum = 11
    val expected = Right(1, 4, 6)
    val actual = ReportRepairSolver.getThreeNumbersEqualToSum(sum, codes)
    assert(actual === expected)
  }
}
