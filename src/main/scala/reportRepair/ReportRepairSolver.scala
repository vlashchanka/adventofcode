package reportRepair

import scala.annotation.tailrec

object ReportRepairSolver {
  type ErrorOrNumbers[T] = Either[String, T]
  type Expenses = List[Int]

  @tailrec
  def getNumbersEqualToSum(sum: Int, list: List[Int], set: Set[Int] = Set()): ErrorOrNumbers[(Int, Int)] = {
    if (list.isEmpty) {
      Left(s"Pair to have sum $sum was not found")
    } else {
      val diff = sum - list.head
      if (set.contains(diff)) {
        Right((list.head, diff))
      } else {
        getNumbersEqualToSum(sum, list.tail, Set(list.head) ++ set)
      }
    }
  }

  def getThreeNumbersEqualToSum(sum: Int, list: List[Int], set: Set[Int] = Set()): ErrorOrNumbers[(Int, Int, Int)] = {
    val threeTriplets = list.map(el => (el, getNumbersEqualToSum(sum - el, list, set))).filter {
      case (_, Right(_)) => true
      case _ => false
    }
    val (num1, pair) = threeTriplets.head // any combination is valid, let's take first one
    pair match {
      case Right((num2, num3)) =>
        val numbers = List(num1, num2, num3).sorted
        Right((numbers.head, numbers(1), numbers(2)))
      case _ => Left(s"There are no 3 numbers in the provided list which sum is equal $sum")
    }
  }

  def solve(expenses: Expenses, sum: Int): Unit = {
    getNumbersEqualToSum(sum, expenses) match {
      case Left(err) => println(err)
      case Right((num1, num2)) => {
        val product = num1 * num2
        println(s"Found product of 2 numbers for sum $sum is $product")
      }
    }
    getThreeNumbersEqualToSum(sum, expenses) match {
      case Left(err) => println(err)
      case Right((num1, num2, num3)) =>
        val product = num1 * num2 * num3
        println(s"Found product of 3 numbers ($num1 * $num2 * $num3) for sum $sum is $product")
    }
  }
}
