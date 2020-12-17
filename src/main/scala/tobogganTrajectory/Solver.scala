package tobogganTrajectory

import aocd.Problem

import scala.annotation.tailrec

object Solver extends Problem(2020, 3) {
  @tailrec
  def getTreesNumber(lines: List[String], shiftRight :Int = 3, shiftDown: Int = 1,  pos: Int = 0, trees: Int = 0): Int = {
    if (lines.isEmpty) {
      trees
    } else {
      val line = lines.head
      val newPos = (pos + shiftRight) % line.length
      val treeOrSpace = line.charAt(newPos)
      def getTreesCountAfterMove(trees: Int): Int = {
        if (treeOrSpace == '#') trees + 1 else trees
      }
      getTreesNumber(lines.slice(shiftDown, lines.length), shiftRight, shiftDown, newPos, getTreesCountAfterMove(trees))
    }
  }

  def run(input: List[String]): Unit = {
    val treesCount = getTreesNumber(input.tail)
    println(s"Number of trees: $treesCount")

    val treesSlopes = List(
      getTreesNumber(input.tail, 1, 1),
      getTreesNumber(input.tail, 3, 1),
      getTreesNumber(input.tail, 5, 1),
      getTreesNumber(input.tail, 7, 1),
      getTreesNumber(input.slice(2, input.length), 1, 2),
    )

    val treesSlopesProduct = treesSlopes.map(BigInt(_)).product

    println(s"Trees slopes product: $treesSlopesProduct")
  }
}
