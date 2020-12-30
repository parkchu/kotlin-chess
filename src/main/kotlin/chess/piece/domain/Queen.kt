package chess.piece.domain

import chess.board.domain.Position

class Queen (team: Team): Piece(team) {
    override val type = Type.QUEEN

    override fun getMovePositions(sourcePosition: Position, targetPosition: Position): List<Position> {
        return listOf()
    }
}
