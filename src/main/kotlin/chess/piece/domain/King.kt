package chess.piece.domain

class King (team: Team): Piece(team) {
    override val score: Int = 10
    override val name: String = "k"
}
