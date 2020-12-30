package chess.piece.domain

import chess.board.domain.Position

class King (team: Team): Piece(team) {
    override val type = Type.KING

    override fun ableMoveIt(sourcePosition: Position, targetPosition: Position): Boolean {
        return false
    }
}
