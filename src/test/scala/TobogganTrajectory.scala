import org.scalatest.FunSuite
import org.scalatest.Matchers.convertToAnyShouldWrapper
import tobogganTrajectory.Solver

import scala.io.Source

class TobogganTrajectory extends FunSuite {
  test("should count trees correctly") {
    val list = Source.fromResource("03.example.txt").getLines().toList
    Solver.getTreesNumber(list.tail) shouldBe 7
  }
}
