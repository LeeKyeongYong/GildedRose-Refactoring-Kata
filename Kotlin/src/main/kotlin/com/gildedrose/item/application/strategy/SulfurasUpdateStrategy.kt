package com.gildedrose.item.application.strategy

import com.gildedrose.item.domain.Item
import com.gildedrose.item.domain.vo.ItemType

class SulfurasUpdateStrategy : ItemUpdateStrategy {
    override fun getSupportedItemType() = ItemType.SULFURAS
    override fun update(item: Item) { /* SULFURAS는 변경 없음 */ }
}