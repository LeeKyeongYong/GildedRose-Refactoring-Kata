package com.gildedrose.domain

import com.gildedrose.item.domain.Item
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Item 클래스 테스트")
class ItemTest {

    @Nested
    @DisplayName("Item 생성 테스트")
    inner class CreateItemTest {

        @ParameterizedTest
        @ValueSource(ints = [-1, 51])
        @DisplayName("quality가 0~50 범위를 벗어나면 예외가 발생한다")
        fun `quality가 0~50 범위를 벗어나면 예외가 발생한다`(quality: Int) {
            // when & then
            assertThatThrownBy { Item("Test Item", 10, quality) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("quality는 0~50의 값을 가져야합니다.")
        }

        @Test
        @DisplayName("sellIn이 음수로 주어지면 예외가 발생한다")
        fun `sellIn이 음수로 주어지면 예외가 발생한다`() {
            // when & then
            assertThatThrownBy { Item("Test Item", -1, 10) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("sellIn은 음수가 될 수 없습니다.")
        }
    }
}