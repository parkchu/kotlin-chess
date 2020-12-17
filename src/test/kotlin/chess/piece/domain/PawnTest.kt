package chess.piece.domain

import chess.constant.PiecesPoint.PAWN
import chess.constant.Team
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PawnTest {

    @Test
    fun makePawn() {
        val whitePawn = Pawn(Team.WHITE)
        val blackPawn = Pawn(Team.BLACK)

        assertThat(whitePawn.value).isEqualTo(PAWN)
        assertThat(whitePawn.team).isEqualTo(Team.WHITE)
        assertThat(blackPawn.value).isEqualTo(PAWN)
        assertThat(blackPawn.team).isEqualTo(Team.BLACK)
    }
}
