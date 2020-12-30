package chess.piece.domain

import chess.board.domain.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KingTest {
    @Test
    fun moveKing() {
        val king = Piece.WHITE_KING
        val sourcePosition = Position(2, 2)
        val north = Position(2, 1)
        val northEast = Position(3, 1)
        val east = Position(3, 2)
        val southEast = Position(3, 3)
        val south = Position(2, 3)
        val southWest = Position(1, 3)
        val west = Position(1, 2)
        val northWest = Position(1, 1)

        assertThat(king.getMovePositions(sourcePosition, north)).isNotEmpty
        assertThat(king.getMovePositions(sourcePosition, northEast)).isNotEmpty
        assertThat(king.getMovePositions(sourcePosition, east)).isNotEmpty
        assertThat(king.getMovePositions(sourcePosition, southEast)).isNotEmpty
        assertThat(king.getMovePositions(sourcePosition, south)).isNotEmpty
        assertThat(king.getMovePositions(sourcePosition, southWest)).isNotEmpty
        assertThat(king.getMovePositions(sourcePosition, west)).isNotEmpty
        assertThat(king.getMovePositions(sourcePosition, northWest)).isNotEmpty
    }

    @Test
    fun canNotMove() {
        val king = Piece.WHITE_KING
        val sourcePosition = Position(1, 1)
        val targetPosition = Position(0, 1)

        val boolean = king.getMovePositions(sourcePosition, targetPosition)

        assertThat(boolean).isEmpty()
    }
}
