package chess.board.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun initBoard() {
        val board = Board()

        board.init()

        val result = board.print()
        val compareTarget = "RNBQKBNR\nPPPPPPPP\n$MIDDLE_BLANK\npppppppp\nrnbqkbnr"
        assertThat(result).isEqualTo(compareTarget)
    }

    companion object {
        const val MIDDLE_BLANK = "........\n........\n........\n........"
    }
}
