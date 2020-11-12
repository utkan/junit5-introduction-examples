package de.mannodermaus.example.common.test.test

import de.mannodermaus.example.common.Rank
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.converter.SimpleArgumentConverter
import org.junit.jupiter.params.provider.ValueSource

class RankTests {

    @ParameterizedTest
    @ValueSource(strings = ["J", "Q", "K", "A"])
    internal fun testExplicitConversionWithAnnotatedParameter(@ConvertWith(RankConverter::class) rank: Rank) {
        assertNotNull(rank)
    }

    class RankConverter : SimpleArgumentConverter() {
        override fun convert(source: Any, targetType: Class<*>?): Any {
            return Rank.parse(source.toString())
        }
    }
}