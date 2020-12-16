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

  test("should detect valid password for new policy") {
    PasswordValidator.isValidForNewPolicy("1-2 c: cdnccgs") shouldBe true
  }

  test("should detect incorrect password for new policy when no matches") {
    PasswordValidator.isValidForNewPolicy("1-2 c: dsccdef") shouldBe false
  }
  test("should detect incorrect password for new policy for 2 matches") {
    PasswordValidator.isValidForNewPolicy("1-2 c: ccdef") shouldBe false
  }
}
