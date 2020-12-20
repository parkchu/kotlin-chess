package chess

import chess.board.domain.Board

fun main() {
    val board = Board()
    board.init()
    do {
        val value = readLine()!!
        val result = if (value == "start") {
            println(board.print())
            true
        } else {
            false
        }
    } while (result)
}
