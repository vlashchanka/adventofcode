import org.scalatest.FunSuite
import org.scalatest.Matchers.convertToAnyShouldWrapper
import passportPhilosophy.PasswordValidator

class PassportPhilosophyTest extends FunSuite {
  test("should detect valid password") {
    PasswordValidator.isValid("1-2 c: nccgs") shouldBe true
  }

  test("should detect incorrect password") {
    PasswordValidator.isValid("3-4 c: absdef") shouldBe false
  }
}
