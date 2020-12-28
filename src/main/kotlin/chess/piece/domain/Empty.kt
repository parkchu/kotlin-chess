package chess.piece.domain

class Empty (team: Team): Piece(team) {
    override val type = Type.EMPTY
}
