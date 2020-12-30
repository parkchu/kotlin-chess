package chess

import chess.board.view.ChessView
import chess.game.domain.ChessGame

fun main() {
    val chess = ChessGame()
    chess.init()
    do {
        val inputValue = readLine()!!
        val result = ChessView.printError { chess.isPlaying(inputValue) }
        ChessView.print(chess.getPiecesList())
    } while (result)
}
