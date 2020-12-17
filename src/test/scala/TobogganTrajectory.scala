import org.scalatest.FunSuite
import org.scalatest.Matchers.convertToAnyShouldWrapper
import tobogganTrajectory.Solver

import scala.io.Source

class TobogganTrajectory extends FunSuite {
  test("should count trees correctly for shift (3,1)") {
    val list = Source.fromResource("03.example.txt").getLines().toList
    Solver.getTreesNumber(list.tail) shouldBe 7
  }
  test("should count trees correctly for shift (1,1)") {
    val list = Source.fromResource("03.example.txt").getLines().toList
    Solver.getTreesNumber(list.tail, 1, 1) shouldBe 2
  }
  test("should count trees correctly for shift (5,1)") {
    val list = Source.fromResource("03.example.txt").getLines().toList
    Solver.getTreesNumber(list.tail, 5, 1) shouldBe 3
  }
  test("should count trees correctly for shift (7,1)") {
    val list = Source.fromResource("03.example.txt").getLines().toList
    Solver.getTreesNumber(list.tail, 7, 1) shouldBe 4
  }
  test("should count trees correctly for shift (1,2)") {
    val list = Source.fromResource("03.example.txt").getLines().toList
    Solver.getTreesNumber(list.slice(2, list.length), 1, 2) shouldBe 2
  }
}