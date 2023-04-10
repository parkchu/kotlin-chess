package chess.game.domain.piece

import chess.game.domain.board.Distance

class Pawn(
    team: Team
) : Piece(team) {
    override fun isMovableDetail(distance: Distance): Boolean {
        if (distance.rankDistance == team.forwardDirection) {
            return distance.rankDistance in -1..1
        }
        return distance.fileDistance == 0 && distance.rankDistance == team.forwardDirection * 2
    }
}
