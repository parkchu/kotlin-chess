package chess.game.domain.piece

import chess.game.domain.board.Distance

class King(
    team: Team
) : Piece(team) {
    override fun isMovableDetail(distance: Distance): Boolean {
        return distance.fileDistance in -1..1 && distance.rankDistance in -1..1
    }
}
