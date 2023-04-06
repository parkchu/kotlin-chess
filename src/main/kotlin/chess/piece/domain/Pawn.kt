package chess.piece.domain

import chess.board.domain.Distance

class Pawn(
    team: Team
) : Piece(team) {
    override fun isMovable(distance: Distance): Boolean {
        if (distance.rankDistance == team.forwardDirection) {
            return distance.rankDistance in -1..1
        }
        return distance.fileDistance == 0 && distance.rankDistance == team.forwardDirection * 2
    }
}
