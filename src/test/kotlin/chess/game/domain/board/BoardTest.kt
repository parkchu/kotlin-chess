package chess.game.domain.board

import chess.game.domain.piece.King
import chess.game.domain.piece.Knight
import chess.game.domain.piece.Pawn
import chess.game.domain.piece.Piece
import chess.game.domain.piece.Queen
import chess.game.domain.piece.Rook
import chess.game.domain.piece.Team
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

val EMPTY_BOARD: Map<File, Map<Rank, Piece?>> = File.values().associateWith { Rank.values().associateWith { null } }

class BoardTest {
    @Test
    fun initBoard() {
        val board = Board()

        board.init()

        val blackKing = board.findNotNull(Coordinate("e8"))
        assertThat(blackKing.isBlack()).isTrue
        assertThat(blackKing::class).isEqualTo(King::class)

        val whiteQueen = board.findNotNull(Coordinate("d1"))
        assertThat(whiteQueen.isWhite()).isTrue
        assertThat(whiteQueen::class).isEqualTo(Queen::class)
    }

    @Test
    fun movePiece() {
        val board = Board()
        board.init()
        val currentCoordinate = Coordinate("e2")
        val targetCoordinate = Coordinate("e3")

        board.move(currentCoordinate, targetCoordinate)

        val sourcePoint = board.find(currentCoordinate)
        val targetPoint = board.findNotNull(targetCoordinate)
        assertThat(sourcePoint).isNull()
        assertThat(targetPoint.isWhite()).isTrue
        assertThat(targetPoint::class).isEqualTo(Pawn::class)
    }

    @Test
    fun takePiece() {
        val points: Map<File, MutableMap<Rank, Piece?>> = EMPTY_BOARD.map { it.key to it.value.toMutableMap() }.toMap()
        points[File.A]!![Rank.ONE] = Rook(Team.WHITE)
        points[File.A]!![Rank.EIGHT] = Rook(Team.BLACK)
        val board = Board(points)
        val currentCoordinate = Coordinate("a1")
        val targetCoordinate = Coordinate("a8")

        board.move(currentCoordinate, targetCoordinate)

        val sourcePoint = board.find(currentCoordinate)
        val targetPoint = board.findNotNull(targetCoordinate)
        assertThat(sourcePoint).isNull()
        assertThat(targetPoint.isWhite()).isTrue
        assertThat(targetPoint::class).isEqualTo(Rook::class)
    }

    @Test
    fun moveWithSameTeam() {
        val points: Map<File, MutableMap<Rank, Piece?>> = EMPTY_BOARD.map { it.key to it.value.toMutableMap() }.toMap()
        points[File.A]!![Rank.ONE] = Rook(Team.WHITE)
        points[File.A]!![Rank.EIGHT] = Rook(Team.WHITE)
        val board = Board(points)
        val currentCoordinate = Coordinate("a1")
        val targetCoordinate = Coordinate("a8")

        assertThatThrownBy {
            board.move(currentCoordinate, targetCoordinate)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("해당 좌표로 움직일 수 없습니다. ($targetCoordinate)")


        val sourcePoint = board.findNotNull(currentCoordinate)
        val targetPoint = board.findNotNull(targetCoordinate)
        assertThat(sourcePoint.isWhite()).isTrue
        assertThat(sourcePoint::class).isEqualTo(Rook::class)
        assertThat(targetPoint.isWhite()).isTrue
        assertThat(targetPoint::class).isEqualTo(Rook::class)
    }

    @Test
    fun moveWithObstacle() {
        val points: Map<File, MutableMap<Rank, Piece?>> = EMPTY_BOARD.map { it.key to it.value.toMutableMap() }.toMap()
        points[File.A]!![Rank.ONE] = Rook(Team.WHITE)
        points[File.A]!![Rank.SIX] = Rook(Team.BLACK)
        val board = Board(points)
        val currentCoordinate = Coordinate("a1")
        val targetCoordinate = Coordinate("a8")

        assertThatThrownBy {
            board.move(currentCoordinate, targetCoordinate)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("해당 좌표로 움직일 수 없습니다. ($targetCoordinate)")


        val sourcePoint = board.findNotNull(currentCoordinate)
        val targetPoint = board.find(targetCoordinate)
        assertThat(sourcePoint.isWhite()).isTrue
        assertThat(sourcePoint::class).isEqualTo(Rook::class)
        assertThat(targetPoint).isNull()
    }

    @Test
    fun moveKnightWithObstacle() {
        val points: Map<File, MutableMap<Rank, Piece?>> = EMPTY_BOARD.map { it.key to it.value.toMutableMap() }.toMap()
        points[File.A]!![Rank.ONE] = Knight(Team.WHITE)
        points[File.A]!![Rank.TWO] = Rook(Team.BLACK)
        val board = Board(points)
        val currentCoordinate = Coordinate("a1")
        val targetCoordinate = Coordinate("b3")

        board.move(currentCoordinate, targetCoordinate)

        val sourcePoint = board.find(currentCoordinate)
        val targetPoint = board.findNotNull(targetCoordinate)
        assertThat(sourcePoint).isNull()
        assertThat(targetPoint.isWhite()).isTrue
        assertThat(targetPoint::class).isEqualTo(Knight::class)
    }
}