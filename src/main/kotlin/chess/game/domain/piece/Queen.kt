package chess.game.domain.piece

import chess.game.domain.board.Distance

class Queen(
    team: Team
) : Piece(team) {
    override fun isMovableDistance(distance: Distance): Boolean {
        val bishopMovable = distance.absoluteFileDistance - distance.absoluteRankDistance == 0
        val rookMovable = distance.fileDistance == 0 || distance.rankDistance == 0

        return bishopMovable || rookMovable
    }
}
