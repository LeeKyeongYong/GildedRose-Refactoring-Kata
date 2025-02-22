package com.gildedrose.item.application.strategy

import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

class BackstagePassesStrategy : ItemUpdateStrategy {
    override fun getSupportedItemType() = ItemType.BACKSTAGE_PASSES
}