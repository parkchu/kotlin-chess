package chess.game.domain.piece

import chess.game.domain.board.Coordinate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KnightTest {
    @Test
    fun `움직일 수 있는 거리임`() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("a3")

        val result = knight.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isTrue
    }

    @Test
    fun `움직일 수 없는 거리임`() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("d3")

        val result = knight.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }
}
