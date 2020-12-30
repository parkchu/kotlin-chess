package chess.piece.domain

import chess.board.domain.Board.Companion.COLUMN_RANGE
import chess.board.domain.Board.Companion.RAW_RANGE
import chess.board.domain.Position

class King(team: Team) : Piece(team) {
    override val type = Type.KING

    override fun ableMoveIt(sourcePosition: Position, targetPosition: Position): Boolean {
        val positions = Direction.moveKing(sourcePosition).filter { it.column in COLUMN_RANGE && it.raw in RAW_RANGE }
        return positions.contains(targetPosition)
    }
}
