package com.gildedrose.item.application.strategy

import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

class NormalUpdateStrategy : ItemUpdateStrategy {

    override fun getSupportedItemType(): ItemType {
        return ItemType.NORMAL
    }

    override fun update(item: Item) {
        val sellIn = item.sellIn - 1
        val quality = item.quality - 1

        item.update(
            updatedSellIn = sellIn,
            updatedQuality = quality
        )
    }
}