package chess.game.domain.piece

import chess.game.domain.board.Distance

class Rook(
    team: Team
) : Piece(team) {
    override fun isMovableDistance(distance: Distance): Boolean {
        return distance.fileDistance == 0 || distance.rankDistance == 0
    }
}
