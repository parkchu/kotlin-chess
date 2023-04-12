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
        val targetCoordinate = Coordinate("e3")

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

    @Test
    fun `대각선 앞에 상대팀 기물이 있을 경우 해당 좌표로 움직일 수 있음`() {
        val whitePawn = Pawn(Team.WHITE)
        val blackPawn = Pawn(Team.BLACK)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("d3")

        val result = whitePawn.isMovable(currentCoordinate.getDistance(targetCoordinate), blackPawn)

        assertThat(result).isTrue
    }

    @Test
    fun `대각선 앞에 같은팀 기물이 있을 경우 해당 좌표로 움직일 수 없음`() {
        val whitePawn = Pawn(Team.WHITE)
        val whiteKing = King(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("d3")

        val result = whitePawn.isMovable(currentCoordinate.getDistance(targetCoordinate), whiteKing)

        assertThat(result).isFalse
    }

    @Test
    fun `대각선 앞에 기물이 없을 경우 해당 좌표로 움직일 수 없음`() {
        val whitePawn = Pawn(Team.WHITE)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("d3")

        val result = whitePawn.isMovable(currentCoordinate.getDistance(targetCoordinate), null)

        assertThat(result).isFalse
    }

    @Test
    fun `처음 움직일 경우 두칸 앞으로 움직일 수 있음`() {
        val whitePawn = Pawn(Team.WHITE, true)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e4")

        val result = whitePawn.isMovable(currentCoordinate.getDistance(targetCoordinate), null)

        assertThat(result).isTrue
    }

    @Test
    fun `처음 움직이는게 아닐 경우 두칸 앞으로 움직일 수 없음`() {
        val whitePawn = Pawn(Team.WHITE, false)
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e4")

        val result = whitePawn.isMovable(currentCoordinate.getDistance(targetCoordinate), null)

        assertThat(result).isFalse
    }
}
