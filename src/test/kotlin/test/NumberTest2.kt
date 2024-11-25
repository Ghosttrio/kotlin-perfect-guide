package test

import io.kotest.core.spec.style.*
import io.kotest.matchers.shouldBe

class NumberTest2 : WordSpec({
    "1 + 2" should {
        "be equal to 3" { (1 + 2) shouldBe 3 }
    }
})

class NumberTest21 : WordSpec({
    "add" When {
        "1 + 2" should {
            "be equal to 3" { (1 + 2) shouldBe 3 }
        }
    }
})

class NumberTest3 : FunSpec({
    test("tes") {0 shouldBe 0}
    context("aa") {
        context("aa") {
            test("22") { 22 shouldBe  22}
        }
    }
})

class NumberTest7 : FeatureSpec({
    feature("aa") {
        val x = 1
        scenario("x is 1 at first") { x shouldBe  1}
        feature("bb") {
            scenario("2") {(x+1) shouldBe  2}
        }
    }
})

class NumberTest8: BehaviorSpec({
    Given("aa") {
        When("bb") {
            val x = 1
            And("cc") {
                Then("dd") { (x + 1) shouldBe 2 }
            }
        }
    }
})

class NumberTest9: AnnotationSpec() {
    @Test fun `aa`() { (2 + 2) shouldBe 4 }
}