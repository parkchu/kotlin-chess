package chess

import chess.board.domain.Board
import chess.board.domain.Position

fun main() {
    val board = Board()
    board.init()
    do {
        val value = readLine()!!
        val values = value.split(" ")
        val result = when {
            value == "start" -> {
                println(board.print())
                true
            }
            checkValue(values) -> {
                val sourcePosition = Board.toPosition(values[1])
                val targetPosition = Board.toPosition(values.last())
                board.move(sourcePosition, targetPosition)
                println(board.print())
                true
            }
            else -> {
                false
            }
        }
    } while (result)
}

fun checkValue(values: List<String>): Boolean {
    return (values.first() == "move" && checkPosition(values[1]) && checkPosition(values.last()))
}

fun checkPosition(stringPosition: String): Boolean {
    return try {
        val position = Position(stringPosition)
        true
    } catch (e: Exception) {
        false
    }
}
