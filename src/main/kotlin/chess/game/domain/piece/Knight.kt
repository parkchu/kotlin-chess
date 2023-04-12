package chess.game.domain.piece

import chess.game.domain.board.Distance

class Knight(
    team: Team
) : Piece(team) {
    override fun isMovableDistance(distance: Distance): Boolean {
        return distance.absoluteFileDistance * distance.absoluteRankDistance == 2
    }

    override fun isKnight(): Boolean = true
}
