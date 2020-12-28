package chess.piece.domain

class Pawn(team: Team) : Piece(team) {
    override val score: Int = 1
    override val name: String = "p"
}
