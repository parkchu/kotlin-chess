package chess.piece.domain

class Knight (team: Team): Piece(team) {
    override val score: Int = 3
    override val name: String = "n"
}
