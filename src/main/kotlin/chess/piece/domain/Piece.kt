package chess.piece.domain

import chess.board.domain.Coordinate

abstract class Piece(
    val team: Team
) {
    open val whiteMovements: List<List<Int>> = listOf()
    open val blackMovements: List<List<Int>> = listOf()

    open fun getMovableCoordinates(coordinate: Coordinate): List<Coordinate> = listOf()

    fun isWhite() = team.isWhite()

    fun isBlack() = team.isBlack()
}

enum class Team() {
    WHITE,
    BLACK;

    fun isWhite() = this == WHITE

    fun isBlack() = this == BLACK
}
