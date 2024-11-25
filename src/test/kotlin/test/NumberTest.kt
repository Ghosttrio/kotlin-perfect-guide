package test

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldEndWith

class NumberTest : StringSpec({
    "2 + 2 should be 4" { (2 + 2) shouldBe 4 }
})


fun isOdd() = object : Matcher<Int> {
    override fun test(value: Int): MatcherResult {
        return MatcherResult(
            value % 2 != 0,
            { "$value should be odd" },
            { "$value should not be odd" }
        )
    }
}


class NumberTestWithInspect : StringSpec({
    val numbers = Array(10) { it + 1 }

    "all are non-negative" {
        numbers.forAll { it shouldBeGreaterThanOrEqual 0 }
    }
})


class ParseTest : StringSpec({
    "invalid String" {
        val e = shouldThrow<NumberFormatException> { "abc".toInt() }
        e.message shouldEndWith "\"abc\""
    }
})