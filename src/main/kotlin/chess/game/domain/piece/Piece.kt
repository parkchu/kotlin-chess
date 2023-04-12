package chess.game.domain.piece

import chess.game.domain.board.Distance

abstract class Piece(
    val team: Team
) {
    fun isMovable(distance: Distance, targetPiece: Piece? = null): Boolean {
        if (distance.isStationary()) {
            return false
        }
        return isMovableDetail(distance, targetPiece)
    }

    open fun isMovableDetail(distance: Distance, targetPiece: Piece?): Boolean {
        if (targetPiece == null || isEnemy(targetPiece)) {
            return isMovableDistance(distance)
        }
        return false
    }

    open fun isMovableDistance(distance: Distance): Boolean = false

    fun isWhite() = team.isWhite()

    fun isBlack() = team.isBlack()

    fun isEnemy(piece: Piece) = team.isEnemy(piece.team)

    open fun isKnight(): Boolean = false

    open fun isPawn(): Boolean = false

    open fun isKing(): Boolean = false
}

enum class Team(val forwardDirection: Int) {
    WHITE(1),
    BLACK(-1);

    fun isWhite() = this == WHITE

    fun isBlack() = this == BLACK

    fun isEnemy(team: Team) = this != team
}
