package de.mannodermaus.example.common.test.assertions

import de.mannodermaus.example.common.Deck
import de.mannodermaus.example.common.EmptyDeckException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class AssertThrowsTests {

    @Test
    @DisplayName("Trying to draw from an empty Deck will throw an Exception")
    fun drawingFromEmptyDeckThrowsException() {
        val deck = Deck(cards = emptyList())
        assertThrows<EmptyDeckException> {
            deck.draw()
        }
    }

    @Test
    @DisplayName("Trying to draw from an empty Deck will throw an Exception - failing")
    fun drawingFromEmptyDeckThrowsExceptionTestFails() {
        val deck = Deck(cards = emptyList())
        assertDoesNotThrow {
            deck.draw()
        }
    }
}
