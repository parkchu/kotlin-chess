package chess.board.domain

import chess.piece.domain.King
import chess.piece.domain.Queen
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointsTest {
    @Test
    fun initPoints() {
        val points = Points()

        points.init()

        val blackKing = points.find(Coordinate("e8"))
        assertThat(blackKing).isNotNull
        assertThat(blackKing!!.isBlack()).isTrue
        assertThat(blackKing::class).isEqualTo(King::class)

        val whiteQueen = points.find(Coordinate("d1"))
        assertThat(whiteQueen).isNotNull
        assertThat(whiteQueen!!.isWhite()).isTrue
        assertThat(whiteQueen::class).isEqualTo(Queen::class)
    }
}
