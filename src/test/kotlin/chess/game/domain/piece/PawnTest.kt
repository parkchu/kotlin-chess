package chess.game.domain.piece

import chess.game.domain.board.Coordinate
import chess.game.domain.piece.Pawn
import chess.game.domain.piece.Team
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PawnTest {
    @Test
    fun makePawn() {
        val pawn = Pawn(Team.WHITE)

        assertThat(pawn.isWhite()).isTrue
    }

    @Test
    fun isMovableCoordinates() {
        val pawn = Pawn(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e4")

        val result = pawn.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isTrue
    }

    @Test
    fun isNotMovableCoordinates() {
        val pawn = Pawn(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e1")

        val result = pawn.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }

    @Test
    fun doNotMove() {
        val pawn = Pawn(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e2")

        val result = pawn.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }
}
