package chess.piece.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PawnTest {

    @Test
    fun makePawn() {
        val pawn = Pawn()

        assertThat(pawn.value).isEqualTo(1)
    }
}
