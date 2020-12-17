package chess.board.domain

import chess.constant.Team
import chess.piece.Piece
import chess.piece.domain.Pawn

class Board {
    val pieces: List<Piece>
        get() = _pieces.toList()
    private val _pieces: MutableList<Piece> = mutableListOf()

    fun addPiece(piece: Piece) {
        _pieces.add(piece)
    }

    companion object {
        val BLACK_PAWN = Pawn(Team.BLACK)
        val BLACK_BISHOP = Pawn(Team.BLACK)
        val BLACK_ROOK = Pawn(Team.BLACK)
        val BLACK_KNIGHT = Pawn(Team.BLACK)
        val BLACK_QUEEN = Pawn(Team.BLACK)
        val BLACK_KING = Pawn(Team.BLACK)
        val WHITE_PAWN = Pawn(Team.WHITE)
        val WHITE_BISHOP = Pawn(Team.WHITE)
        val WHITE_ROOK = Pawn(Team.WHITE)
        val WHITE_KNIGHT = Pawn(Team.WHITE)
        val WHITE_QUEEN = Pawn(Team.WHITE)
        val WHITE_KING = Pawn(Team.WHITE)
    }
}
