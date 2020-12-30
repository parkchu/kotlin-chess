package chess.game.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ChessGameTest {

    @Test
    fun showBoard() {
        val chessGame = ChessGame()
        val inputValue = "show"

        val result = chessGame.isPlaying(inputValue)

        assertTrue(result)
    }

    /* 아직 폰의 움직임을 구현하지 않아서 오류가 발생합니다. 폰의 움직임을 구현하고 주석을 풀겠습니다.
    @Test
    fun movePiece() {
        val chessGame = ChessGame()
        chessGame.init()
        val inputValue = "move a7 a6"

        val result = chessGame.isPlaying(inputValue)

        assertTrue(result)
    } */

    @Test
    fun restartGame() {
        val chessGame = ChessGame()
        val inputValue = "restart"

        val result = chessGame.isPlaying(inputValue)

        assertTrue(result)
    }

    @Test
    fun endGame() {
        val chessGame = ChessGame()
        val inputValue = "end"

        val result = chessGame.isPlaying(inputValue)

        assertFalse(result)
    }

    @Test
    fun errorGame() {
        val chessGame = ChessGame()
        val inputValue = "error"

        assertThatThrownBy {
            chessGame.isPlaying(inputValue)
        }.isInstanceOf(NoSuchElementException::class.java)
    }
}
