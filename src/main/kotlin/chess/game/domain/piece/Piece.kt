package chess.game.domain.piece

import chess.game.domain.board.Distance

abstract class Piece(
    val team: Team
) {
    fun isMovable(distance: Distance): Boolean {
        if (distance.isImmovable()) {
            return false
        }
        return isMovableDetail(distance)
    }

    open fun isMovableDetail(distance: Distance): Boolean = false

    fun isWhite() = team.isWhite()

    fun isBlack() = team.isBlack()

    fun isEnemy(team: Team) = this.team != team

    open fun isKnight(): Boolean = false
}

enum class Team(val forwardDirection: Int) {
    WHITE(1),
    BLACK(-1);

    fun isWhite() = this == WHITE

    fun isBlack() = this == BLACK
}
