package chess.game.domain.piece

import chess.game.domain.board.Distance
import kotlin.math.abs

class Knight(
    team: Team
) : Piece(team) {
    override fun isMovableDetail(distance: Distance): Boolean {
        return abs(distance.fileDistance * distance.rankDistance) == 2
    }

    override fun isKnight(): Boolean = true
}
