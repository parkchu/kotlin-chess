package chess.board.domain

import chess.piece.domain.Piece
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
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

    @Test
    fun findPiece() {
        val board = Board()
        board.init()

        val piece = board.findPieceIt(A1)

        assertThat(piece.type).isEqualTo(Piece.Type.ROOK)
        assertThat(piece.print()).isEqualTo("R")
    }

    @DisplayName("없는 위치를 보낼경우")
    @Test
    fun findPiece2() {
        val board = Board()
        board.init()

        assertThatThrownBy {
            board.findPieceIt(Q1)
        }.isInstanceOf(IllegalArgumentException::class.java)

        assertThatThrownBy {
            board.findPieceIt(A0)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun addPiece() {
        val board = Board()

        val piece = Piece.BLACK_KING
        board.addIt(A4, piece)

        assertThat(board.findPieceIt(A4)).isEqualTo(piece)
    }

    @Test
    fun getPiecesNumber() {
        val board = Board()
        board.init()
        board.addIt(A4, Piece.WHITE_KNIGHT)

        val blackKnightNumber = board.getPiecesNumber(Piece.BLACK_KNIGHT)
        val whiteKnightNumber = board.getPiecesNumber(Piece.WHITE_KNIGHT)

        assertThat(blackKnightNumber).isEqualTo(2)
        assertThat(whiteKnightNumber).isEqualTo(3)
    }

    @Test
    fun getScore() {
        val board = Board()
        board.init()
        board.addIt(A4, Piece.WHITE_QUEEN)

        val blackScore = board.getScore(Piece.Team.BLACK)
        val whiteScore = board.getScore(Piece.Team.WHITE)

        assertThat(blackScore).isEqualTo(49)
        assertThat(whiteScore).isEqualTo(58)
    }

    @Test
    fun movePiece() {
        val board = Board()
        board.init()

        val sourcePosition = A7
        val targetPosition = A6
        board.move(sourcePosition, targetPosition)

        assertThat(board.findPieceIt(sourcePosition)).isEqualTo(Piece.EMPTY)
        assertThat(board.findPieceIt(targetPosition)).isEqualTo(Piece.WHITE_PAWN)
    }

    companion object {
        const val MIDDLE_BLANK = "........\n........\n........\n........"
        val A1 = Position("a1")
        val Q1 = Position("q1")
        val A0 = Position("a0")
        val A4 = Position("a4")
        val A6 = Position("a6")
        val A7 = Position("a7")
    }
}
