package tobogganTrajectory

import aocd.Problem

import scala.annotation.tailrec

object Solver extends Problem(2020, 3) {

  def getTreesCount(lines: List[String], shiftRight :Int, shiftDown: Int): Int = {
    val tree = '#'
    @tailrec
    def getTreesOnLines(lines: List[String], pos: Int, trees: Int): Int = {
      if (lines.isEmpty) {
        trees
      } else {
        val line = lines.head
        val newPos = (pos + shiftRight) % line.length
        val treeOrSpace = line.charAt(newPos)
        val treesCountAfterMove = if (treeOrSpace == tree) trees + 1 else trees
        getTreesOnLines(lines.slice(shiftDown, lines.length), newPos, treesCountAfterMove)
      }
    }
    getTreesOnLines(lines.slice(shiftDown, lines.length), 0, 0)
  }

  def run(input: List[String]): Unit = {
    val treesCount = getTreesCount(input, 3, 1)
    println(s"Number of trees: $treesCount")

    val treesSlopes = List(
      getTreesCount(input, 1, 1),
      getTreesCount(input, 3, 1),
      getTreesCount(input, 5, 1),
      getTreesCount(input, 7, 1),
      getTreesCount(input, 1, 2),
    )

    val treesSlopesProduct = treesSlopes.foldLeft(1.toLong)((m, n) => m * n)

    println(s"Trees slopes product: $treesSlopesProduct")
  }
}
