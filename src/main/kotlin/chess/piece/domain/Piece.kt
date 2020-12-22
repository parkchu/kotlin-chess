package chess.piece.domain

class Piece(val team: Team, val type: Type) {
    enum class Team(val value: String) {
        WHITE("white"),
        BLACK("black"),
        EMPTY("empty")
    }

    enum class Type(val score: Int, val string: String) {
        PAWN(1, "p"),
        BISHOP(3, "b"),
        KNIGHT(3, "n"),
        ROOK(5, "r"),
        QUEEN(9, "q"),
        KING(10, "k"),
        EMPTY(0, ".")
    }

    fun print(): String {
        val name = type.string
        return if (team == Team.WHITE) {
            name
        } else {
            name.toUpperCase()
        }
    }

    fun isWhite(): Boolean = team == Team.WHITE

    fun isBlack(): Boolean = team == Team.BLACK

    companion object {
        val BLACK_PAWN = Piece(Team.BLACK, Type.PAWN)
        val BLACK_BISHOP = Piece(Team.BLACK, Type.BISHOP)
        val BLACK_ROOK = Piece(Team.BLACK, Type.ROOK)
        val BLACK_KNIGHT = Piece(Team.BLACK, Type.KNIGHT)
        val BLACK_QUEEN = Piece(Team.BLACK, Type.QUEEN)
        val BLACK_KING = Piece(Team.BLACK, Type.KING)
        val WHITE_PAWN = Piece(Team.WHITE, Type.PAWN)
        val WHITE_BISHOP = Piece(Team.WHITE, Type.BISHOP)
        val WHITE_ROOK = Piece(Team.WHITE, Type.ROOK)
        val WHITE_KNIGHT = Piece(Team.WHITE, Type.KNIGHT)
        val WHITE_QUEEN = Piece(Team.WHITE, Type.QUEEN)
        val WHITE_KING = Piece(Team.WHITE, Type.KING)
        val EMPTY = Piece(Team.EMPTY, Type.EMPTY)
    }
}
