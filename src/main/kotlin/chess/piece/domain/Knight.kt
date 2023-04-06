package chess.piece.domain

import chess.board.domain.Coordinate
import kotlin.math.abs

class Knight(
    team: Team
) : Piece(team) {
    override fun isMovable(currentCoordinate: Coordinate, targetCoordinate: Coordinate): Boolean {
        val distance = currentCoordinate.getDistance(targetCoordinate)

        if (distance.fileDistance == 0 && distance.rankDistance == 0) {
            return false
        }
        return abs(distance.fileDistance * distance.rankDistance) == 2
    }
}
