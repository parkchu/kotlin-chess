package chess.game.domain.piece

import chess.game.domain.board.Distance
import kotlin.math.abs

class Queen(
    team: Team
) : Piece(team) {
    override fun isMovableDetail(distance: Distance): Boolean {
        val bishopMovable = abs(distance.fileDistance) - abs(distance.rankDistance) == 0
        val rookMovable = distance.fileDistance == 0 || distance.rankDistance == 0

        return bishopMovable || rookMovable
    }
}
