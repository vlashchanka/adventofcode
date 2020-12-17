package tobogganTrajectory

import aocd.Problem

import scala.annotation.tailrec

object Solver extends Problem(2020, 3) {
  @tailrec
  def getTreesNumber(lines: List[String], pos: Int = 0, shift :Int = 3, trees: Int = 0): Int = {
    if (lines.isEmpty) {
      trees
    } else {
      val line = lines.head
      val newPos = (pos + shift) % line.length
      val treeOrSpace = line.charAt(newPos)
      def getTreesCountAfterMove(trees: Int): Int = {
        if (treeOrSpace == '#') trees + 1 else trees
      }
      getTreesNumber(lines.tail, newPos, shift, getTreesCountAfterMove(trees))
    }
  }

  def run(input: List[String]): Unit = {
    val treesCount = getTreesNumber(input.tail)
    println(s"Number of trees: $treesCount")
  }
}
