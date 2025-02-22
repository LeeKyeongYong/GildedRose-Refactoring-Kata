package com.gildedrose.item.application.strategy

import com.gildedrose.item.domain.*

object QualityUpdateHelper {
    fun calculateNewQuality(item: Item, type: ItemType): Int {
        return when (type) {
            ItemType.AGED_BRIE -> item.quality + 1
            ItemType.BACKSTAGE_PASSES -> when {
                item.sellIn > 10 -> item.quality + 1
                item.sellIn > 5 -> item.quality + 2
                item.sellIn > 0 -> item.quality + 3
                else -> 0
            }
            ItemType.CONJURED -> item.quality - 2
            ItemType.NORMAL -> item.quality - 1
            ItemType.SULFURAS -> item.quality
        }
    }
}

