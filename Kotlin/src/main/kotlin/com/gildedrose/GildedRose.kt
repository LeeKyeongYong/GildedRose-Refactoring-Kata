package com.gildedrose

import com.gildedrose.item.application.ItemUpdater
import com.gildedrose.item.domain.Item

class GildedRose(
    private val items: List<Item>
) {
    fun updateQuality() {
        val itemUpdater = ItemUpdater.createStrategies()
        items.forEach { itemUpdater.update(it) }
    }
}

