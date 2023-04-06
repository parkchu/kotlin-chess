package chess.piece.domain

import chess.board.domain.Distance

class King(
    team: Team
) : Piece(team) {
    override fun isMovable(distance: Distance): Boolean {
        return distance.fileDistance in -1..1 && distance.rankDistance in -1..1
    }
}
