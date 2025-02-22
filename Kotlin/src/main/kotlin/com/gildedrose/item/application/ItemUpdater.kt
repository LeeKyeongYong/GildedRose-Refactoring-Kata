package com.gildedrose.item.application

import com.gildedrose.item.application.strategy.*
import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

object ItemUpdater {
    private val itemUpdateStrategies: Map<ItemType, ItemUpdateStrategy> = mapOf(
        ItemType.NORMAL to NormalUpdateStrategy(),
        ItemType.AGED_BRIE to AgedBrieUpdateStrategy(),
        ItemType.SULFURAS to SulfurasUpdateStrategy(),
        ItemType.BACKSTAGE_PASSES to BackstagePassesStrategy(),
        ItemType.CONJURED to ConjuredStrategy()
    )

    fun update(item: Item) {
        val itemType = ItemType.from(item.name)
        itemUpdateStrategies[itemType]?.update(item)
    }
}
