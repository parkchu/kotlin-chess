package chess.piece.domain

class Rook (team: Team): Piece(team) {
    override val score: Int = 5
    override val name: String = "r"
}
