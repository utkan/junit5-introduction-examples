package de.mannodermaus.example.common.test.test

import de.mannodermaus.example.common.Rank
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Test

class AceValueTests {

    @Test
    internal fun testValueOfAnAceCard() {
        for (score in 1..21) {
            val aceValue = Rank.Ace.value(currentSum = score)

            when (score) {
                in 1..10 -> assertTrue(aceValue == 11)
                else -> assertTrue(aceValue == 1)
            }
        }
    }

    @RepeatedTest(value = 21, name = "Ace value test {currentRepetition}")
    internal fun testValueOfAnAceCardWithRepeatedTest(repetitionInfo: RepetitionInfo) {

        val score = repetitionInfo.currentRepetition
        val aceValue = Rank.Ace.value(currentSum = score)

        when (score) {
            in 1..10 -> assertTrue(aceValue == 11)
            else -> assertTrue(aceValue == 1)
        }
    }
}