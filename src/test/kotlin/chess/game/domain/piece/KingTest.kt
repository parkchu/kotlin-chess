package chess.game.domain.piece

import chess.game.domain.board.Coordinate
import chess.game.domain.piece.King
import chess.game.domain.piece.Team
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KingTest {
    @Test
    fun isMovableCoordinates() {
        val king = King(Team.WHITE)
        val currentCoordinate = Coordinate("e1")
        val targetCoordinate = Coordinate("d2")

        val result = king.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isTrue
    }

    @Test
    fun isNotMovableCoordinates() {
        val king = King(Team.WHITE)
        val currentCoordinate = Coordinate("d1")
        val targetCoordinate = Coordinate("c3")

        val result = king.isMovable(currentCoordinate.getDistance(targetCoordinate))

        assertThat(result).isFalse
    }
}
