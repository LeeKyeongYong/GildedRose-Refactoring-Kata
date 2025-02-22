package com.gildedrose.domain.vo

import com.gildedrose.item.domain.vo.ItemType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThat

@ExtendWith(org.junit.jupiter.api.extension.ParameterResolver::class)
@DisplayName("ItemType 테스트")
class ItemTypeTest {

    @Nested
    @DisplayName("from() 함수 테스트")
    inner class FromFunctionTest {

        @Test
        @DisplayName("주어진 이름에 해당하는 ItemType을 반환한다")
        fun `주어진 이름에 해당하는 ItemType을 반환한다`() {
            // given
            val name = "Aged Brie"

            // when
            val result = ItemType.from(name)

            // then
            assertThat(result).isEqualTo(ItemType.AGED_BRIE)
        }

        @ParameterizedTest
        @ValueSource(strings = ["Unknown Item", "Random", "Legendary"])
        @DisplayName("존재하지 않는 이름이면 기본값(NORMAL)을 반환한다")
        fun `존재하지 않는 이름이면 기본값(NORMAL)을 반환한다`(name: String) {
            // when
            val result = ItemType.from(name)

            // then
            assertThat(result).isEqualTo(ItemType.NORMAL)
        }
    }
}