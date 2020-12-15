import org.scalatest.FunSuite
import org.scalatest.Matchers.convertToAnyShouldWrapper
import passportPhilosophy.PasswordPolicy

class PassportPhilosophyTest extends FunSuite {
  test("should detect valid password") {
    PasswordPolicy.isValid("1-2 c: nccgs") shouldBe true
  }

  test("should detect incorrect password") {
    PasswordPolicy.isValid("3-4 c: absdef") shouldBe false
  }
}
