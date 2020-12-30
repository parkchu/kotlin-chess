package chess.piece.domain

class King(team: Team) : Piece(team) {
    override val type = Type.KING

    override fun getDirections(): List<Direction> {
        return Direction.moveKing()
    }
}
