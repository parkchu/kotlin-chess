package chess.game.domain.piece

import chess.game.domain.board.Distance

class Bishop(
    team: Team
) : Piece(team) {
    override fun isMovableDistance(distance: Distance): Boolean {
        return distance.absoluteFileDistance - distance.absoluteRankDistance == 0
    }
}
