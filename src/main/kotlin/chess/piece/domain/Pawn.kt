package chess.piece.domain

import chess.board.domain.Point
import chess.piece.Piece

class Pawn : Piece {
    override val value = 1

    override fun getMovablePoint(point: Point): List<Point> {
        return listOf()
    }
}
