package de.mannodermaus.example.common.test.test

import org.junit.jupiter.api.*

class SetupAndTeardownKotlinTests {

    companion object {
        @JvmStatic
        @BeforeAll
        internal fun setUp() {
            println("Callback before the first test is executed")
        }

        @JvmStatic
        @AfterAll
        internal fun tearDown() {
            println("Callback after all tests have been executed")
        }
    }

    @Test
    fun test1() {
        println("   Running Test 1")
    }

    @Test
    fun test2() {
        println("   Running Test 2")
    }

    @Test
    fun test3() {
        println("   Running Test 3")
    }
}