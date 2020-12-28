package chess.piece.domain

class Empty (team: Team): Piece(team) {
    override val score: Int = 0
    override val name: String = "."
}
