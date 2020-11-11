package de.mannodermaus.example.common.test.test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// Not visible on command line onşy in html generation
@DisplayName("Super awkward, long class name Tests")
class SuperAwkwardLongClassNameTests {

    @DisplayName("Given method name, when this need to be read, readability is way better!")
    @Test
    internal fun superLongName() {
        println("super long name test running")
    }
}