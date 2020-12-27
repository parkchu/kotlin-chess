package chess.board.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun makePosition() {
        val a1 = "a1"

        val position = Position(a1)

        assertThat(position.column).isEqualTo(1)
        assertThat(position.raw).isEqualTo(1)
    }
}
