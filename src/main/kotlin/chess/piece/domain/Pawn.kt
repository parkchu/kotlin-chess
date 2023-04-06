package chess.piece.domain

import chess.board.domain.Coordinate
import chess.board.domain.Distance

class Pawn(
    team: Team
) : Piece(team) {
    override val whiteMovements: List<Distance> = listOf(Distance(0, 1), Distance(0, 2), Distance(1, 1), Distance(-1, 1))
    override val blackMovements: List<Distance> = listOf(Distance(0, -1), Distance(0, -2), Distance(1, -1), Distance(-1, -1))

    override fun isMovable(currentCoordinate: Coordinate, targetCoordinate: Coordinate): Boolean {
        val distance = currentCoordinate.getDistance(targetCoordinate)

        if (team.isWhite()) {
            return whiteMovements.contains(distance)
        }
        return blackMovements.contains(distance)
    }
}
