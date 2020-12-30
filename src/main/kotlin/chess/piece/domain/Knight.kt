package chess.piece.domain

class Knight(team: Team) : Piece(team) {
    override val type = Type.KNIGHT

    override fun getDirections(): List<Direction> {
        return Direction.moveKnight()
    }
}
