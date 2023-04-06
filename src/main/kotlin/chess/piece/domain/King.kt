package chess.piece.domain

import chess.board.domain.Coordinate

class King(
    team: Team
) : Piece(team) {
    override fun isMovable(currentCoordinate: Coordinate, targetCoordinate: Coordinate): Boolean {
        val distance = currentCoordinate.getDistance(targetCoordinate)

        if (distance.fileDistance == 0 && distance.rankDistance == 0) {
            return false
        }
        return distance.fileDistance in -1..1 && distance.rankDistance in -1..1
    }
}
