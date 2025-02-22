package com.gildedrose
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("GildedRose 품질 업데이트 테스트")
class GildedRoseTest {

    private lateinit var gildedRose: GildedRose

    private fun createItem(name: String, sellIn: Int, quality: Int): Item {
        return Item(name, sellIn, quality)
    }

    @Nested
    @DisplayName("일반 아이템")
    inner class GeneralItemTest {

        @Test
        @DisplayName("품질은 음수가 될 수 없다")
        fun qualityCannotBeNegative() {
            val item = createItem("Normal Item", 1, 0)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertEquals(0, item.quality)
        }

        @Test
        @DisplayName("일반 아이템은 시간이 지나면 품질과 유통기한이 감소한다")
        fun normalItemQualityAndSellInDecrease() {
            val item = createItem("Normal Item", 1, 1)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertAll(
                { assertEquals(0, item.sellIn) },
                { assertEquals(0, item.quality) }
            )
        }
    }

    @Nested
    @DisplayName("Aged Brie")
    inner class AgedBrieTest {

        @Test
        @DisplayName("시간이 지나면 품질이 증가한다")
        fun agedBrieQualityIncreases() {
            val item = createItem("Aged Brie", 1, 1)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertEquals(2, item.quality)
        }
    }

    @Nested
    @DisplayName("Sulfuras")
    inner class SulfurasTest {

        @Test
        @DisplayName("판매 기한이 지나도 품질과 유통기한이 변하지 않는다")
        fun sulfurasNeverDecreases() {
            val item = createItem("Sulfuras, Hand of Ragnaros", 1, 1)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertAll(
                { assertEquals(1, item.sellIn) },
                { assertEquals(1, item.quality) }
            )
        }
    }

    @Nested
    @DisplayName("Backstage Passes")
    inner class BackstagePassesTest {

        @Test
        @DisplayName("판매 기한이 10일 초과일 때 품질이 1 증가한다")
        fun qualityIncreasesByOneAboveTenDays() {
            val item = createItem("Backstage passes to a TAFKAL80ETC concert", 11, 1)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertAll(
                { assertEquals(10, item.sellIn) },
                { assertEquals(2, item.quality) }
            )
        }

        @Test
        @DisplayName("판매 기한이 10일 이하 5일 초과일 때 품질이 2 증가한다")
        fun qualityIncreasesByTwoBetweenFiveAndTenDays() {
            val item = createItem("Backstage passes to a TAFKAL80ETC concert", 6, 1)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertAll(
                { assertEquals(5, item.sellIn) },
                { assertEquals(3, item.quality) }
            )
        }

        @Test
        @DisplayName("판매 기한이 5일 이하일 때 품질이 3 증가한다")
        fun qualityIncreasesByThreeBelowFiveDays() {
            val item = createItem("Backstage passes to a TAFKAL80ETC concert", 3, 1)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertAll(
                { assertEquals(2, item.sellIn) },
                { assertEquals(4, item.quality) }
            )
        }

        @Test
        @DisplayName("판매 기한이 지나면 품질이 0이 된다")
        fun qualityDropsToZeroAfterConcert() {
            val item = createItem("Backstage passes to a TAFKAL80ETC concert", 0, 1)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertAll(
                { assertEquals(-1, item.sellIn) },
                { assertEquals(0, item.quality) }
            )
        }
    }

    @Nested
    @DisplayName("Conjured 아이템")
    inner class ConjuredItemTest {

        @Test
        @DisplayName("일반 아이템보다 2배 빠르게 품질이 감소한다")
        fun conjuredItemQualityDecreasesTwiceAsFast() {
            val item = createItem("Conjured", 10, 10)
            gildedRose = GildedRose(listOf(item))

            gildedRose.updateQuality()

            assertAll(
                { assertEquals(9, item.sellIn) },
                { assertEquals(8, item.quality) }
            )
        }
    }
}
