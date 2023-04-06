package chess.piece.domain

import chess.board.domain.Distance
import kotlin.math.abs

class Queen(
    team: Team
) : Piece(team) {
    override fun isMovable(distance: Distance): Boolean {
        val bishopMovable = abs(distance.fileDistance) - abs(distance.rankDistance) == 0
        val rookMovable = distance.fileDistance == 0 || distance.rankDistance == 0

        return bishopMovable || rookMovable
    }
}
