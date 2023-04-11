package chess.game.domain.piece

import chess.game.domain.board.Coordinate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class QueenTest {
    @Test
    fun `움직일 수 있는 거리임`() {
        val queen = Queen(Team.WHITE)
        val currentCoordinate = Coordinate("d1")
        val targetCoordinate = Coordinate("a1")

        val result = queen.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isTrue
    }

    @Test
    fun `움직일 수 없는 거리임`() {
        val queen = Queen(Team.WHITE)
        val currentCoordinate = Coordinate("d1")
        val targetCoordinate = Coordinate("c3")

        val result = queen.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }
}
