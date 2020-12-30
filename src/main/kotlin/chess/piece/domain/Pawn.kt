package chess.piece.domain


class Pawn(team: Team) : Piece(team) {
    override val type = Type.PAWN

    override fun getDirections(): List<Direction> {
        return if (isWhite()) {
            Direction.moveWhitePawn()
        } else {
            Direction.moveBlackPawn()
        }
    }
}
