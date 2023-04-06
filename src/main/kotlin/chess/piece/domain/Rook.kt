package chess.piece.domain

import chess.board.domain.Distance

class Rook(
    team: Team
) : Piece(team) {
    override fun isMovable(distance: Distance): Boolean {
        return distance.fileDistance == 0 || distance.rankDistance == 0
    }
}
