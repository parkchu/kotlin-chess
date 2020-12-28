package chess

import chess.board.domain.Board
import chess.board.domain.Position

fun main() {
    val board = Board()
    board.init()
    do {
        val result = test(board)
    } while (result)
}

fun test(board: Board): Boolean {
    val value = readLine()!!
    val values = value.split(" ")
    return when {
        value == "start" -> startGame(board)

        checkValue(values) -> movePiece(board, values)

        else -> false
    }
}

fun startGame(board: Board): Boolean {
    println(board.print())
    return true
}

fun movePiece(board: Board, values: List<String>): Boolean {
    val sourcePosition = Board.toPosition(values[1])
    val targetPosition = Board.toPosition(values.last())
    board.move(sourcePosition, targetPosition)
    println(board.print())
    return true
}

fun checkValue(values: List<String>): Boolean {
    return (values.first() == "move" && checkPosition(values[1]) && checkPosition(values.last()))
}

fun checkPosition(stringPosition: String): Boolean {
    return try {
        Position(stringPosition)
        true
    } catch (e: Exception) {
        false
    }
}
