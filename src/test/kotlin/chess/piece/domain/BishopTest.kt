package chess.piece.domain

import chess.board.domain.Coordinate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BishopTest {
    @Test
    fun isMovableCoordinates() {
        val bishop = Bishop(Team.WHITE)
        val currentCoordinate = Coordinate("c1")
        val targetCoordinate = Coordinate("f4")

        val result = bishop.isMovable(currentCoordinate, targetCoordinate)

        assertThat(result).isTrue
    }

    @Test
    fun isNotMovableCoordinates() {
        val pawn = Bishop(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("a2")

        val result = pawn.isMovable(currentCoordinate, targetCoordinate)

        assertThat(result).isFalse
    }
}
