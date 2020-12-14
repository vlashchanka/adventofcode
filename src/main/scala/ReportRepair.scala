import reportRepair.{ReportRepairInput, ReportRepairSolver}

object ReportRepair extends App {
  val sumToFind = 2020
  val expenses = ReportRepairInput.getExpenses()
  ReportRepairSolver.solve(expenses, sumToFind)
}