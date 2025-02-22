package com.gildedrose.item.application.strategy

import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

class ConjuredStrategy : ItemUpdateStrategy {
    override fun getSupportedItemType() = ItemType.CONJURED
}