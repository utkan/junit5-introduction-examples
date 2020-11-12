package de.mannodermaus.example.common.test.test

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.AnnotationConsumer
import java.util.stream.Stream

class CustomSourceTest {

    @ParameterizedTest
    @JsonSource(text = "[{\"score\":11, \"accValue\":1},{\"score\":4, \"accValue\":11}]")
    internal fun test(jsonNode: JsonNode) {
        val score = jsonNode["score"].asInt()
        val accValue = jsonNode["accValue"].asInt()

        when {
            score < 11 -> assertEquals(11, accValue)
            else -> assertEquals(1, accValue)
        }
    }

    @ArgumentsSource(JsonArgumentProvider::class)
    annotation class JsonSource(val text: String)

    class JsonArgumentProvider : ArgumentsProvider, AnnotationConsumer<JsonSource> {

        private lateinit var text: String

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return ObjectMapper().readTree(text).toList().stream().map { Arguments.of(it) }
        }

        override fun accept(t: JsonSource) {
            this.text = t.text
        }

    }
}