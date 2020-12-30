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

        assertThat(king.ableMoveIt(sourcePosition, north)).isTrue
        assertThat(king.ableMoveIt(sourcePosition, northEast)).isTrue
        assertThat(king.ableMoveIt(sourcePosition, east)).isTrue
        assertThat(king.ableMoveIt(sourcePosition, southEast)).isTrue
        assertThat(king.ableMoveIt(sourcePosition, south)).isTrue
        assertThat(king.ableMoveIt(sourcePosition, southWest)).isTrue
        assertThat(king.ableMoveIt(sourcePosition, west)).isTrue
        assertThat(king.ableMoveIt(sourcePosition, northWest)).isTrue
    }

    @Test
    fun canNotMove() {
        val king = Piece.WHITE_KING
        val sourcePosition = Position(1, 1)
        val targetPosition = Position(0, 1)

        val boolean = king.ableMoveIt(sourcePosition, targetPosition)

        assertThat(boolean).isFalse
    }
}
