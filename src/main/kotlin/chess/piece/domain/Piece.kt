package chess.piece.domain

import chess.board.domain.Coordinate
import chess.board.domain.Distance

abstract class Piece(
    val team: Team
) {
    fun isMovable(currentCoordinate: Coordinate, targetCoordinate: Coordinate): Boolean {
        val distance = currentCoordinate.getDistance(targetCoordinate)

        if (distance.fileDistance == 0 && distance.rankDistance == 0) {
            return false
        }
        return isMovable(distance)
    }

    open fun isMovable(distance: Distance): Boolean = false

    fun isWhite() = team.isWhite()

    fun isBlack() = team.isBlack()
}

enum class Team(val forwardDirection: Int) {
    WHITE(1),
    BLACK(-1);

    fun isWhite() = this == WHITE

    fun isBlack() = this == BLACK
}
