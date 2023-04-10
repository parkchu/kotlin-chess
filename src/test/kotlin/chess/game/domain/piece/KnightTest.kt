package chess.game.domain.piece

import chess.game.domain.board.Coordinate
import chess.game.domain.piece.Knight
import chess.game.domain.piece.Team
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class KnightTest {
    @Test
    fun isMovableCoordinates() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("a3")

        val result = knight.isMovable(currentCoordinate.getDistance(targetCoordinate))

        Assertions.assertThat(result).isTrue
    }

    @Test
    fun isNotMovableCoordinates() {
        val knight = Knight(Team.WHITE)
        val currentCoordinate = Coordinate("b1")
        val targetCoordinate = Coordinate("d3")

        val result = knight.isMovable(currentCoordinate.getDistance(targetCoordinate))

        Assertions.assertThat(result).isFalse
    }
}
