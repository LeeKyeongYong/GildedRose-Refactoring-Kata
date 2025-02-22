package com.gildedrose.item.domain

class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {

    init {
        validate()
    }

    fun update(updatedSellIn: Int, updatedQuality: Int) {
        sellIn = updatedSellIn
        quality = updatedQuality.coerceIn(MINIMUM_QUALITY, MAXIMUM_QUALITY)
    }

    private fun validate() {
        require(quality in MINIMUM_QUALITY..MAXIMUM_QUALITY) { "quality는 0~50의 값을 가져야 합니다." }
        require(sellIn >= MINIMUM_SELL_IN) { "sellIn은 음수가 될 수 없습니다." }
    }

    companion object {
        private const val MINIMUM_QUALITY = 0
        private const val MAXIMUM_QUALITY = 50
        private const val MINIMUM_SELL_IN = 0
    }
}
