package com.gildedrose.item.application.strategy

import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

interface ItemUpdateStrategy {
    fun getSupportedItemType(): ItemType
    fun update(item: Item) {
        item.update(
            updatedSellIn = item.sellIn - 1,
            updatedQuality = QualityUpdateHelper.calculateNewQuality(item, getSupportedItemType())
        )
    }
}
