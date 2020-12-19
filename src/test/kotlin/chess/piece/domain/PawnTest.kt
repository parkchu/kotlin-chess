package chess.piece.domain

import chess.constant.PiecesPoint.PAWN
import chess.constant.Team
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PawnTest {
    private val whitePawn = Pawn(Team.WHITE)
    private val blackPawn = Pawn(Team.BLACK)

    @Test
    fun makePawn() {
        assertThat(whitePawn.value).isEqualTo(PAWN)
        assertThat(whitePawn.team).isEqualTo(Team.WHITE)
        assertThat(blackPawn.value).isEqualTo(PAWN)
        assertThat(blackPawn.team).isEqualTo(Team.BLACK)
    }

    @DisplayName("Black Pawn 이면 P를 White Pawn 이면 p를 출력한다.")
    @Test
    fun printValue() {
        assertThat(whitePawn.print()).isEqualTo("p")
        assertThat(blackPawn.print()).isEqualTo("P")
    }
}
