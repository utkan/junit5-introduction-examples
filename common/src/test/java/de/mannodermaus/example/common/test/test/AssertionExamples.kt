package de.mannodermaus.example.common.test.test

import de.mannodermaus.example.common.Card
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("Assertion Examples")
class AssertionExamples {

    @DisplayName("- same")
    @Test
    internal fun `example assertion - same`() {
        val card1 = Card.parse("A♦")
        val card2 = Card.parse("A♦")

        // should fail
//        Assertions.assertSame(card1, card2)
    }

    @DisplayName(" - equals")
    @Test
    internal fun `example assertion`() {
        val card1 = Card.parse("A♦")
        val card2 = Card.parse("A♦")

        assertEquals(card1, card2)
    }

    @Test
    internal fun multipleAssertions() {
        assertAll("Multiple checks",
                { assertEquals("Hello World", "Hello " + "World") },
                { assertTrue(2 + 2 == 4) }
        )
    }

    @Test
    internal fun testMultiplePropertiesOfAUser() {
        val user = User(
                firstName = "Hoge",
                lastName = "Foobar",
                age = 21,
                postalAddresses = listOf("361 Yellow Road, Randomville, FL 32792", "Gelbe Straße 361, 32792 Zufalshausen")
        )

        assertAll("Test a user",
                { assertNotNull(user.firstName) },
                { assertNotNull(user.lastName) },
                {
                    assertAll("Age-related tests",
                            { assertEquals(21, user.age) },
                            { assertTrue(user.isAdult()) }
                    )
                },
                {
                    assertAll("Address tests",
                            { assertEquals(1, user.postalAddresses.size) },
                            { assertTrue(user.canReceiveMail()) }
                    )
                }
        )

    }
}

data class User(
        val firstName: String,
        val lastName: String,
        val age: Int,
        val postalAddresses: List<String>
) {
    fun isAdult() = age > 18

    fun canReceiveMail() = postalAddresses.isNotEmpty()
}