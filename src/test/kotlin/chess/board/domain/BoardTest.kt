package chess.board.domain

import chess.constant.PiecesPoint
import chess.constant.Team
import chess.piece.Piece
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun createBoard() {
        val board = Board()

        board.addPiece(Board.BLACK_PAWN)

        val piece: Piece = board.pieces.first()
        assertThat(piece.value).isEqualTo(PiecesPoint.PAWN)
        assertThat(piece.team).isEqualTo(Team.BLACK)
        assertThat(board.pieces).hasSize(1)
    }
}
