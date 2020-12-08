package chess.piece

import chess.board.domain.Point

interface Piece {
    val value: Int

    fun getMovablePoint(point: Point): List<Point>
}
