package de.mannodermaus.example.common.test.test

import de.mannodermaus.example.common.ALL_CARDS
import de.mannodermaus.example.common.Deck
import de.mannodermaus.example.common.Session
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue

class SessionTests {

    private lateinit var deck: Deck

    @BeforeEach
    internal fun beforeEachParent() {
        this.deck = Deck(ALL_CARDS)

        println("BeforeEach: Parent")
    }

    @AfterEach
    internal fun afterEachParent() {
        println("AfterEach: Parent")
    }

    @Nested
    inner class SessionTurnTests {

        private lateinit var session: Session

        @BeforeEach
        internal fun beforeEachChild() {
            this.session = Session(deck = deck, player = "Player 1")

            println("BeforeEach: Child")
        }

        @AfterEach
        internal fun afterEachChild() {
            println("AfterEach: Child")
        }

        @DisplayName("Test 1")
        @Test
        internal fun testMethod1InChild() {
            println("Test 1")
            val initialTurn = session.turn

            session.makeTurn()

            assertTrue(session.turn == initialTurn + 1)
        }

        @Test
        @DisplayName("Test 2")
        internal fun testMethod2InChild() {
            println("Test 2")
            val oldDeckSize = deck.size

            session.makeTurn()

            assertTrue(oldDeckSize == deck.size + 1)
        }
    }
}