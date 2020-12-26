package chess.point.domain

import chess.piece.domain.Piece.Companion.BLACK_KING
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointsTest {

    @Test
    fun makePoints() {
        Points(8, 8)
    }

    @Test
    fun addPieceAndFindPiece() {
        val points = Points(8, 8)

        points.addIt(1, 1, BLACK_KING)

        val piece = points.findIt(1, 1)
        assertThat(piece).isEqualTo(BLACK_KING)
    }
}
