package chess.game.domain.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `게임을 시작함`() {
        val game = Game()

        game.start()

        assertThat(game.isInProgress).isTrue
    }
}
