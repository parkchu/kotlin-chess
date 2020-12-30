package chess.piece.domain

import chess.board.domain.Position

enum class Direction(val column: Int, val raw: Int) {
    NORTH(0, -1),
    NORTH_EAST(1, -1),
    EAST(1, 0),
    SOUTH_EAST(1, 1),
    SOUTH(0, 1),
    SOUTH_WEST(-1, 1),
    WEST(-1, 0),
    NORTH_WEST(-1, -1),

    NORTH_NORTH(0, -2),
    SOUTH_SOUTH(0, 2),

    NNW(-1, -2),
    NNE(1, -2),
    EEN(2, -1),
    EES(2, 1),
    SSE(1, 2),
    SSW(-1, 2),
    WWS(-2, 1),
    WWN(-2, -1);

    fun toPosition(): Position = Position(column, raw)

    fun plusIt(position: Position): Position = Position(column + position.column, raw + position.raw)

    companion object {
        fun moveKing(): List<Direction> {
            return values().take(8)
        }

        fun moveKnight(): List<Direction> {
            return values().drop(10)
        }

        fun moveWhitePawn(): List<Direction> {
            return listOf(NORTH, NORTH_EAST, NORTH_WEST, NORTH_NORTH)
        }

        fun moveBlackPawn(): List<Direction> {
            return listOf(SOUTH, SOUTH_EAST, SOUTH_WEST, SOUTH_SOUTH)
        }
    }
}
