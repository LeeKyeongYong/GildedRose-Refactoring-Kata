package com.gildedrose.item.domain.vo

enum class ItemType(val type: String) {
    NORMAL("normal"),
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured");

    companion object {
        private val TYPE_MAP = entries.associateBy { it.type }

        fun from(name: String): ItemType = TYPE_MAP[name] ?: NORMAL
    }
}
