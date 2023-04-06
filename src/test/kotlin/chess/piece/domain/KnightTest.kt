package chess.piece.domain

import chess.board.domain.Coordinate
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class KnightTest {
    @Test
    fun isMovableCoordinates() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("a3")

        val result = knight.isMovable(currentCoordinate, targetCoordinate)

        Assertions.assertThat(result).isTrue
    }

    @Test
    fun isNotMovableCoordinates() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("d3")

        val result = knight.isMovable(currentCoordinate, targetCoordinate)

        Assertions.assertThat(result).isFalse
    }
}
