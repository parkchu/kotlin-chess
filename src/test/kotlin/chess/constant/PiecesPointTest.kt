package chess.constant

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PiecesPointTest {

    @DisplayName("value 값이 같으면 같은 enum 으로 보는지 테스트")
    @Test
    fun checkSameValue() {
        assertThat(PiecesPoint.BISHOP).isNotEqualTo(PiecesPoint.KNIGHT)
        assertThat(PiecesPoint.KNIGHT).isNotEqualTo(PiecesPoint.BISHOP)
    }
}
