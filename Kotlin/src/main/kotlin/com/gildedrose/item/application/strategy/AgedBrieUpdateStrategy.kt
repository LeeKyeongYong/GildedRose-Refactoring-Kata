package com.gildedrose.item.application.strategy

import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

class AgedBrieUpdateStrategy : ItemUpdateStrategy {
    override fun getSupportedItemType() = ItemType.AGED_BRIE
}
