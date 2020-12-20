package chess.line.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LineTest {

    @Test
    fun addString() {
        val line = Line()

        line.add("나는")

        assertThat(line.string).isEqualTo("나는")

        line.add("주한이다")

        assertThat(line.string).isEqualTo("나는\n주한이다")
    }
}
