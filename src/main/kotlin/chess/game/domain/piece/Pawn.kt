package chess.game.domain.piece

import chess.game.domain.board.Distance

class Pawn(
    team: Team,
    private var isStationary: Boolean = true
) : Piece(team) {
    override fun isMovableDetail(distance: Distance, targetPiece: Piece?): Boolean {
        if (targetPiece == null) {
            return isForward(distance)
        }
        if (isEnemy(targetPiece)) {
            return distance.absoluteFileDistance == 1 && distance.rankDistance == team.forwardDirection
        }
        return false
    }

    private fun isForward(distance: Distance): Boolean {
        if (distance.fileDistance != 0) {
            return false
        }
        if (distance.rankDistance == team.forwardDirection * 2) {
            return isStationary
        }
        return distance.rankDistance == team.forwardDirection
    }

    override fun isPawn(): Boolean = true

    fun move() {
        isStationary = false
    }
}
