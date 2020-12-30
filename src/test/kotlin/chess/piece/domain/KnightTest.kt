package chess.piece.domain

import chess.board.domain.Position
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class KnightTest {
    @Test
    fun moveKing() {
        val knight = Piece.WHITE_KNIGHT
        val sourcePosition = Position(3, 3)
        val nnw = Position(2, 1)
        val nne = Position(4, 1)
        val een = Position(5, 2)
        val ees = Position(5, 4)
        val sse = Position(4, 5)
        val ssw = Position(2, 5)
        val wws = Position(1, 4)
        val wwn = Position(1, 2)

        Assertions.assertThat(knight.getMovePositions(sourcePosition, nnw)).isNotEmpty
        Assertions.assertThat(knight.getMovePositions(sourcePosition, nne)).isNotEmpty
        Assertions.assertThat(knight.getMovePositions(sourcePosition, een)).isNotEmpty
        Assertions.assertThat(knight.getMovePositions(sourcePosition, ees)).isNotEmpty
        Assertions.assertThat(knight.getMovePositions(sourcePosition, sse)).isNotEmpty
        Assertions.assertThat(knight.getMovePositions(sourcePosition, ssw)).isNotEmpty
        Assertions.assertThat(knight.getMovePositions(sourcePosition, wws)).isNotEmpty
        Assertions.assertThat(knight.getMovePositions(sourcePosition, wwn)).isNotEmpty
    }

    @Test
    fun canNotMove() {
        val knight = Piece.WHITE_KNIGHT
        val sourcePosition = Position(1, 1)
        val targetPosition = Position(0, 1)

        val boolean = knight.getMovePositions(sourcePosition, targetPosition)

        Assertions.assertThat(boolean).isEmpty()
    }
}
