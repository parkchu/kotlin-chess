package chess.piece.domain

class Bishop(team: Team): Piece(team) {
    override val score: Int = 3
    override val name: String = "b"
}
