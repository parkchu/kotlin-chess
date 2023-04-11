package chess.game.domain.piece

import chess.game.domain.board.Coordinate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PawnTest {
    @Test
    fun `화이트 폰 생성함`() {
        val pawn = Pawn(Team.WHITE)

        assertThat(pawn.isWhite()).isTrue
    }

    @Test
    fun `움직일 수 있는 거리임`() {
        val pawn = Pawn(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e4")

        val result = pawn.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isTrue
    }

    @Test
    fun `움직일 수 없는 거리임`() {
        val pawn = Pawn(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e1")

        val result = pawn.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }

    @Test
    fun `현재 좌표로 움직임`() {
        val pawn = Pawn(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e2")

        val result = pawn.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }
}
