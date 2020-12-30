package chess.piece.domain

enum class Direction(private val column: Int, private val raw: Int) {
    NORTH(0, -1),
    NORTH_EAST(1, -1),
    EAST(1, 0),
    SOUTH_EAST(1, 1),
    SOUTH(0, 1),
    SOUTH_WEST(-1, 1),
    WEST(-1, 0),
    NORTH_WEST(-1, -1);

    fun moveIt(column: Int, raw: Int): List<Int> {
        return listOf(column + this.column, raw + this.raw)
    }
}
