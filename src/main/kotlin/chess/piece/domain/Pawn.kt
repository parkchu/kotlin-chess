package chess.piece.domain

import chess.board.domain.Coordinate

class Pawn(
    team: Team
) : Piece(team) {
    override val whiteMovements: List<List<Int>> = listOf(listOf(0, 1), listOf(0, 2), listOf(1, 1), listOf(-1, 1))
    override val blackMovements: List<List<Int>> = listOf(listOf(0, -1), listOf(0, -2), listOf(1, -1), listOf(-1, -1))

    override fun getMovableCoordinates(coordinate: Coordinate): List<Coordinate> {
        if (team.isWhite()) {
            return whiteMovements.mapNotNull { coordinate.move(it[0], it[1]) }
        }
        return blackMovements.mapNotNull { coordinate.move(it[0], it[1]) }
    }

}
