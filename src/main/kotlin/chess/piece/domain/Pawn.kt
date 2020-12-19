package chess.piece.domain

import chess.constant.PiecesPoint
import chess.constant.Team
import chess.piece.Piece

class Pawn(override val team: Team = Team.WHITE) : Piece {
    override val value: PiecesPoint = PiecesPoint.PAWN

    fun print(): String {
        return if (team == Team.WHITE) {
            "p"
        } else {
            "P"
        }
    }
}
