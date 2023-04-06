package chess.piece.domain

import chess.board.domain.Coordinate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PawnTest {
    @Test
    fun makePawn() {
        val pawn = Pawn(Team.WHITE)

        assertThat(pawn.isWhite()).isTrue
    }

    @Test
    fun getMovableCoordinates() {
        val pawn = Pawn(Team.WHITE)
        val coordinate = Coordinate("e2")
        val movableCoordinates = listOf(Coordinate("e3"), Coordinate("e4"), Coordinate("f3"), Coordinate("d3"))

        val result = pawn.getMovableCoordinates(coordinate)

        assertThat(result).isEqualTo(movableCoordinates)
    }
}
