package chess.piece.domain

abstract class Piece(val team: Team) {
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

    open val type: Type = Type.EMPTY

    fun print(): String {
        return if (team == Team.WHITE) {
            type.string
        } else {
            type.string.toUpperCase()
        }
    }

    fun isWhite(): Boolean = team == Team.WHITE

    fun isBlack(): Boolean = team == Team.BLACK

    companion object {
        val BLACK_PAWN = Pawn(Team.BLACK)
        val BLACK_BISHOP = Bishop(Team.BLACK)
        val BLACK_ROOK = Rook(Team.BLACK)
        val BLACK_KNIGHT = Knight(Team.BLACK)
        val BLACK_QUEEN = Queen(Team.BLACK)
        val BLACK_KING = King(Team.BLACK)
        val WHITE_PAWN = Pawn(Team.WHITE)
        val WHITE_BISHOP = Bishop(Team.WHITE)
        val WHITE_ROOK = Rook(Team.WHITE)
        val WHITE_KNIGHT = Knight(Team.WHITE)
        val WHITE_QUEEN = Queen(Team.WHITE)
        val WHITE_KING = King(Team.WHITE)
        val EMPTY = Empty(Team.EMPTY)
    }
}
