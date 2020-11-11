package de.mannodermaus.example.common.test.test

import org.junit.jupiter.api.Test

//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default
class NewInstancePerMethodTests {

    @Test
    fun test1() {
        println("Running Test 1. this=$this")
    }

    @Test
    fun test2() {
        println("Running Test 2. this=$this")
    }

    @Test
    fun test3() {
        println("Running Test 3. this=$this")
    }
}