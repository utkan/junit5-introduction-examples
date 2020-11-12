package de.mannodermaus.example.common.test.test

import de.mannodermaus.example.common.Card
import de.mannodermaus.example.common.Suit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CardTests {

    @ParameterizedTest
    @ValueSource(strings = ["10♦"])
    internal fun testArgumentConversionForCustomClass(card: Card) {
        assertNotNull(card)
        assertEquals(10, card.rank.value(0))
        assertEquals(Suit.Diamonds, card.suit)
        println(card.javaClass.name)
    }
}