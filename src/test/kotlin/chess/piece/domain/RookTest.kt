package chess.piece.domain

import chess.board.domain.Coordinate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RookTest {
    @Test
    fun isMovableCoordinates() {
        val rook = Rook(Team.WHITE)
        val currentCoordinate = Coordinate("a1")
        val targetCoordinate = Coordinate("a5")

        val result = rook.isMovable(currentCoordinate, targetCoordinate)

        assertThat(result).isTrue
    }

    @Test
    fun isNotMovableCoordinates() {
        val rook = Rook(Team.WHITE)
        val currentCoordinate = Coordinate("c1")
        val targetCoordinate = Coordinate("f4")

        val result = rook.isMovable(currentCoordinate, targetCoordinate)

        assertThat(result).isFalse
    }
}
