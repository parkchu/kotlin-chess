package chess.point.domain

import chess.board.domain.CoordinateX
import chess.board.domain.Point
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointTest {
    @Test
    fun makePoint() {
        val point = Point("a", 1)

        assertThat(point.x).isEqualTo(CoordinateX.A)
        assertThat(point.y).isEqualTo(1)
    }
}
