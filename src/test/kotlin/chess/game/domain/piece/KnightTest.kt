package chess.game.domain.piece

import chess.game.domain.board.Coordinate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KnightTest {
    @Test
    fun isMovableCoordinates() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("a3")

        val result = knight.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isTrue
    }

    @Test
    fun isNotMovableCoordinates() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("d3")

        val result = knight.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }
}
