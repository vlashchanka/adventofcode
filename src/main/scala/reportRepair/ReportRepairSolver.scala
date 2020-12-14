package reportRepair

import scala.annotation.tailrec

object ReportRepairSolver {
  type ErrorOrNumber = Either[String, Int]
  type Expenses = List[Int]

  @tailrec
  def getPairProduct(sum: Int, list: List[Int], set: Set[Int] = Set()): ErrorOrNumber = {
    if (list.isEmpty) {
      Left(s"Pair to have sum $sum was not found")
    } else {
      val diff = sum - list.head
      if (set.contains(diff)) {
        return Right(list.head * diff)
      }
      getPairProduct(sum, list.tail, Set(list.head) ++ set)
    }
  }

  def solve(expenses: Expenses, sum: Int): Unit = {
    getPairProduct(sum, expenses) match {
      case Left(err) => println(err)
      case Right(product) => println(s"Found product of 2 numbers for sum $sum is $product")
    }
  }
}
