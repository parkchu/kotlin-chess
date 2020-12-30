package chess.game.domain

import chess.board.domain.Board
import chess.piece.domain.Piece

class ChessGame {
    private val _board = Board()
    private var _turn = Piece.Team.WHITE

    fun init() {
        _board.init()
        _turn = Piece.Team.WHITE
    }

    fun isPlaying(inputValue: String): Boolean {
        val values = inputValue.split(" ")
        return when {
            inputValue == "show" -> true

            checkValue(values) -> movePiece(_board, values)

            inputValue == "restart" -> restartGame(_board)

            inputValue == "end" -> false

            else -> throw NoSuchElementException()
        }
    }

    private fun checkValue(values: List<String>): Boolean {
        return (values.first() == "move" && checkPosition(values[1]) && checkPosition(values.last()))
    }

    private fun checkPosition(stringPosition: String): Boolean {
        return try {
            Board.toPosition(stringPosition)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun movePiece(board: Board, values: List<String>): Boolean {
        val sourcePosition = Board.toPosition(values[1])
        val targetPosition = Board.toPosition(values.last())
        board.move(sourcePosition, targetPosition, _turn)
        changeTurn()
        return true
    }

    private fun changeTurn() {
        _turn = if (_turn == Piece.Team.WHITE) {
            Piece.Team.BLACK
        } else {
            Piece.Team.WHITE
        }
    }

    private fun restartGame(board: Board): Boolean {
        board.init()
        return true
    }

    fun getPiecesList(): List<List<Piece>> {
        return _board.getPiecesList()
    }
}
