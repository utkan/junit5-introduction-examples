package de.mannodermaus.example.common.test.test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SetupAndTearDownTests {

    @BeforeEach
    fun setUp() {
        println("Called before each test method in this class")
    }

    @AfterEach
    fun tearDown() {
        println("Called after each test method in this class")
    }

    @Test
    fun test1() {
        println("   Executing Test 1")
    }

    @Test
    fun test2() {
        println("   Executing Test 2")
    }

    @Test
    fun test3() {
        println("   Executing Test 3")
    }
}