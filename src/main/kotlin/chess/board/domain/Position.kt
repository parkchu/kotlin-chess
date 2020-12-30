package chess.board.domain

data class Position(val column: Int, val raw: Int) {
    constructor(position: String) : this(charToInt(position.first()), Character.getNumericValue(position.last()))

    fun minusIt(position: Position): Position {
        return Position(column - position.column, raw - position.raw)
    }

    companion object {
        fun charToInt(char: Char): Int = char - '`'
    }
}
