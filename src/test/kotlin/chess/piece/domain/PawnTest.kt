package chess.piece.domain

import chess.board.domain.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PawnTest {
    @Test
    fun moveWhitePawn() {
        val pawn = Piece.WHITE_PAWN
        val sourcePosition = Position(3, 3)
        val north = Position(3, 2)
        val northEast = Position(4, 2)
        val northWest = Position(2, 2)
        val northNorth = Position(3, 1)

        assertThat(pawn.getMovePositions(sourcePosition, north)).isNotEmpty
        assertThat(pawn.getMovePositions(sourcePosition, northEast)).isNotEmpty
        assertThat(pawn.getMovePositions(sourcePosition, northWest)).isNotEmpty
        assertThat(pawn.getMovePositions(sourcePosition, northNorth)).isNotEmpty
    }

    @Test
    fun canNotMove() {
        val pawn = Piece.WHITE_PAWN
        val sourcePosition = Position(2, 2)
        val targetPosition = Position(2, 3)

        val boolean = pawn.getMovePositions(sourcePosition, targetPosition)

        assertThat(boolean).isEmpty()
    }

    @Test
    fun moveBlackPawn() {
        val pawn = Piece.BLACK_PAWN
        val sourcePosition = Position(3, 3)
        val south = Position(3, 4)
        val southEast = Position(4, 4)
        val southWest = Position(2, 4)
        val southSouth = Position(3, 5)

        assertThat(pawn.getMovePositions(sourcePosition, south)).isNotEmpty
        assertThat(pawn.getMovePositions(sourcePosition, southEast)).isNotEmpty
        assertThat(pawn.getMovePositions(sourcePosition, southWest)).isNotEmpty
        assertThat(pawn.getMovePositions(sourcePosition, southSouth)).isNotEmpty
    }

    @Test
    fun canNotMoveBlack() {
        val pawn = Piece.BLACK_PAWN
        val sourcePosition = Position(2, 2)
        val targetPosition = Position(2, 1)

        val boolean = pawn.getMovePositions(sourcePosition, targetPosition)

        assertThat(boolean).isEmpty()
    }
}
