package chess.game.domain.game

import chess.game.domain.board.Board

class Game(
    private val board: Board = Board()
) {
    private var _isInProgress = false
    val isInProgress
        get() = _isInProgress

    fun start() {
        board.init()
        _isInProgress = true
    }
}
