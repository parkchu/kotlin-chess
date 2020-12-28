package chess.piece.domain

class Queen (team: Team): Piece(team) {
    override val score: Int = 9
    override val name: String = "q"
}
