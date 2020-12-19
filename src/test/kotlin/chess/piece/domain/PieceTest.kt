package chess.piece.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PieceTest {
    private val whitePawn = Piece.WHITE_PAWN
    private val blackPawn = Piece.BLACK_PAWN

    @Test
    fun makePawn() {
        assertTrue(whitePawn.isWhite())
        assertThat(whitePawn.type).isEqualTo(Piece.Type.PAWN)
        assertTrue(blackPawn.isBlack())
        assertThat(blackPawn.type).isEqualTo(Piece.Type.PAWN)
    }

    @DisplayName("Black Pawn 이면 P를 White Pawn 이면 p를 출력한다.")
    @Test
    fun printValue() {
        assertThat(whitePawn.print()).isEqualTo("p")
        assertThat(blackPawn.print()).isEqualTo("P")
    }
}
