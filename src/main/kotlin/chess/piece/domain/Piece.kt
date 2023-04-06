package chess.piece.domain

import chess.board.domain.Coordinate

abstract class Piece(
    val team: Team
) {
    open fun isMovable(currentCoordinate: Coordinate, targetCoordinate: Coordinate) = false

    fun isWhite() = team.isWhite()

    fun isBlack() = team.isBlack()
}

enum class Team() {
    WHITE,
    BLACK;

    fun isWhite() = this == WHITE

    fun isBlack() = this == BLACK
}
