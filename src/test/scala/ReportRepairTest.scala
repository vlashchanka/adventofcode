import org.scalatest.FunSuite
import reportRepair.ReportRepairSolver

class ReportRepairTest extends FunSuite {
  test("ReportRepairSolver - should return correct number") {
    val codes = List(1, 4, 45, 6, 10, 8)
    val sum = 16
    val expected = Right(60)
    val actual = ReportRepairSolver.getPairProduct(sum, codes)
    assert(actual === expected)
  }

  test("ReportRepairSolver - should return error") {
    val codes = List(1, 4, 45, 6, 10, 8)
    val sum = 3
    val expected = Left("Pair to have sum 3 was not found")
    val actual = ReportRepairSolver.getPairProduct(sum, codes)
    assert(actual === expected)
  }
}
