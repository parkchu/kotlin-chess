package chess.game.domain.piece

import chess.game.domain.board.Distance
import kotlin.math.abs

class Bishop(
    team: Team
) : Piece(team) {
    override fun isMovableDetail(distance: Distance): Boolean {
        return abs(distance.fileDistance) - abs(distance.rankDistance) == 0
    }
}
