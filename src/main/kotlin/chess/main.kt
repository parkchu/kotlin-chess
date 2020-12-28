package chess

import chess.board.domain.Board
import chess.board.domain.Position
import chess.board.view.ChessView

fun main() {
    val board = Board()
    board.init()
    do {
        val result = getResult(board)
    } while (result)
}

fun getResult(board: Board): Boolean {
    val value = readLine()!!
    val values = value.split(" ")
    return when {
        value == "start" -> startGame(board)

        checkValue(values) -> movePiece(board, values)

        value == "end" -> false

        else -> printGuide()
    }
}

fun startGame(board: Board): Boolean {
    ChessView.print(board.getPiecesList())
    return true
}

fun movePiece(board: Board, values: List<String>): Boolean {
    try {
        val sourcePosition = Board.toPosition(values[1])
        val targetPosition = Board.toPosition(values.last())
        board.move(sourcePosition, targetPosition)
        ChessView.print(board.getPiecesList())
    } catch (e: Exception) {
        println(e.message ?: "위치를 잘 입력해주세요")
    }
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

fun printGuide(): Boolean {
    println("start, move .. .., end 중에 입력해주세요")
    return true
}
