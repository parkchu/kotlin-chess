package chess.board.domain

class Position(position: String) {
    val column: Int = charToInt(position.first())
    val raw: Int = Character.getNumericValue(position.last())

    private fun charToInt(char: Char): Int {
        return char - '`'
    }
}
