package chess.piece.domain

import chess.board.domain.Distance
import kotlin.math.abs

class Knight(
    team: Team
) : Piece(team) {
    override fun isMovable(distance: Distance): Boolean {
        return abs(distance.fileDistance * distance.rankDistance) == 2
    }
}
