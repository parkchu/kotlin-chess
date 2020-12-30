package chess.board.domain

import chess.board.view.ChessView
import chess.piece.domain.Piece
import chess.piece.domain.Piece.Companion.WHITE_PAWN
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun initBoard() {
        val board = Board()

        board.init()

        val result = ChessView.print(board.getPiecesList())
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


    @DisplayName("말이 없는 위치를 움직일려고 할 경우의 예외처리")
    @Test
    fun movePiece2() {
        val board = Board()

        assertThatThrownBy {
            board.move(A1, A7)
        }.hasMessage("비어있는 칸은 움직일수 없습니다.")
    }

    @DisplayName("잘못된 위치를 보낼 경우의 예외처리")
    @Test
    fun movePiece3() {
        val board = Board()
        board.init()

        assertThatThrownBy {
            board.move(A0, A7)
        }.hasMessage("존재하지 않는 위치입니다.")

        assertThatThrownBy {
            board.move(A7, A0)
        }.hasMessage("존재하지 않는 위치입니다.")
    }

    @DisplayName("자기 위치로 움직일려는 경우")
    @Test
    fun moveMyself() {
        val board = Board()
        board.init()

        assertThatThrownBy {
            board.move(A7, A7)
        }.hasMessage("자기 위치로는 움직일 수 없습니다.")
    }

    @DisplayName("자기 팀이 있는 위치로 움직일려는 경우")
    @Test
    fun moveMyTeam() {
        val board = Board()
        board.init()

        assertThatThrownBy {
            board.move(E8, E7)
        }.hasMessage("자기 팀이 있는 위치로는 움직일 수 없습니다.")
    }

    @DisplayName("해당 말이 움직일 수 없는 위치로 움직일려는 경우")
    @Test
    fun moveStrangePosition() {
        val board = Board()
        board.init()

        assertThatThrownBy {
            board.move(E8, A1)
        }.hasMessage("해당 말은 움직일 수 없는 위치 입니다.")
    }

    @DisplayName("해당 플레이어의 차례가 아닙니다.")
    @Test
    fun moveEnemyPiece() {
        val board = Board()
        board.init()

        assertThatThrownBy {
            board.move(E8, A1, Piece.Team.BLACK)
        }.hasMessage("white 의 차례가 아닙니다.")
    }

    @DisplayName("앞에 말이 있을 경우 폰을 움직이는 상황")
    @Test
    fun movePawn() {
        val board = Board()
        board.init()
        board.addIt(A6, Piece.BLACK_BISHOP)

        assertThatThrownBy {
            board.move(A7, A6, Piece.Team.WHITE)
        }.hasMessage("해당 말은 움직일 수 없는 위치 입니다.")
    }

    @DisplayName("대각선에 상대말이 있을 경우 폰을 움직이는 상황")
    @Test
    fun movePawn2() {
        val board = Board()
        board.init()
        board.addIt(B6, Piece.BLACK_BISHOP)

        board.move(A7, B6, Piece.Team.WHITE)

        assertThat(board.findPieceIt(B6)).isEqualTo(Piece.WHITE_PAWN)
    }

    @DisplayName("대각선에 말이 없을 경우 폰을 움직이는 상황")
    @Test
    fun movePawn3() {
        val board = Board()
        board.init()

        assertThatThrownBy {
            board.move(A7, B6, Piece.Team.WHITE)
        }.hasMessage("해당 말은 움직일 수 없는 위치 입니다.")
    }

    @DisplayName("한번도 움직이지 않은 폰은 앞으로 2칸 이동할 수 있습니다.")
    @Test
    fun movePawn4() {
        val board = Board()
        board.init()

        board.move(A7, A5)

        assertThat(board.findPieceIt(A5)).isEqualTo(WHITE_PAWN)
    }

    @DisplayName("한번 움직인 폰은 앞으로 2칸 이동할 수 없습니다.")
    @Test
    fun movePawn5() {
        val board = Board()
        board.init()
        board.move(A7, A6)

        assertThatThrownBy {
            board.move(A6, A4)
        }.hasMessage("해당 말은 움직일 수 없는 위치 입니다.")
    }

    companion object {
        const val MIDDLE_BLANK = "........\n........\n........\n........"
        val A1 = Position("a1")
        val Q1 = Position("q1")
        val A0 = Position("a0")
        val A4 = Position("a4")
        val A5 = Position("a5")
        val A6 = Position("a6")
        val A7 = Position("a7")
        val E8 = Position("e8")
        val E7 = Position("e7")
        val B6 = Position("b6")
    }
}
