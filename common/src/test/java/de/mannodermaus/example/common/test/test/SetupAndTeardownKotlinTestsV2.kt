package de.mannodermaus.example.common.test.test

import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SetupAndTeardownKotlinTestsV2 {

    @BeforeAll
    internal fun setUp() {
        println("Before All")
    }

    @AfterAll
    internal fun tearDown() {
        println("After All")
    }

    @BeforeEach
    internal fun beforeEach() {
        println("|__ Before Each")
    }

    @AfterEach
    internal fun afterEach() {
        println("|__ After Each")
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