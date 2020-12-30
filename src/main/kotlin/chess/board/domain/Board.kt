package chess.board.domain

import chess.piece.domain.Piece
import chess.piece.domain.Pieces
import chess.point.domain.Points

class Board {
    private val _points: Points = Points(COLUMN_LENGTH, RAW_LENGTH)
    private val _pieces: Pieces = Pieces()

    fun init() {
        setPawnAllRaw(BLACK_FRONT_LINE, Piece.BLACK_PAWN)
        setPawnAllRaw(WHITE_FRONT_LINE, Piece.WHITE_PAWN)
        setPieces() // 폰을 제외한 나머지 말들 세팅
    }

    private fun setPawnAllRaw(raw: Int, piece: Piece) {
        repeat(COLUMN_LENGTH) { addIt(it + 1, raw, piece) }
    }

    private fun setPieces() {
        repeat(COLUMN_LENGTH) { setPiece(it + 1) }
    }

    private fun setPiece(column: Int) {
        when (column) {
            ROOK -> {
                addPieces(column, BLACK_BACK_LINE, Piece.BLACK_ROOK)
                addPieces(column, WHITE_BACK_LINE, Piece.WHITE_ROOK)
            }
            KNIGHT -> {
                addPieces(column, BLACK_BACK_LINE, Piece.BLACK_KNIGHT)
                addPieces(column, WHITE_BACK_LINE, Piece.WHITE_KNIGHT)
            }
            BISHOP -> {
                addPieces(column, BLACK_BACK_LINE, Piece.BLACK_BISHOP)
                addPieces(column, WHITE_BACK_LINE, Piece.WHITE_BISHOP)
            }
            QUEEN -> {
                addPieces(column, BLACK_BACK_LINE, Piece.BLACK_QUEEN)
                addPieces(column, WHITE_BACK_LINE, Piece.WHITE_QUEEN)
            }
            KING -> {
                addPieces(column, BLACK_BACK_LINE, Piece.BLACK_KING)
                addPieces(column, WHITE_BACK_LINE, Piece.WHITE_KING)
            }
        }
    }

    private fun addPieces(column: Int, raw: Int, piece: Piece) {
        addIt(column, raw, piece)
        if (column < 4) {
            addIt(9 - column, raw, piece)
        }
    }

    private fun addIt(column: Int, raw: Int, piece: Piece) {
        checkColumn(column)
        _points.addIt(column, raw, piece)
        _pieces.addPieceOfTeam(piece)
    }

    fun addIt(position: Position, piece: Piece) {
        checkColumn(position.column)
        _points.addIt(position.column, position.raw, piece)
        _pieces.addPieceOfTeam(piece)
    } // test 코드에서만 사용되고 있는 메소드입니다. 특정 위치에 Piece 를 add 시키는 일이 수행해야 하는 것인지 생각해봅니다.

    private fun checkColumn(column: Int) {
        if (column !in COLUMN_RANGE) {
            throw IllegalArgumentException()
        }
    }

    fun getPiecesNumber(piece: Piece): Int {
        return _pieces.getPiecesNumber(piece)
    }

    fun getScore(team: Piece.Team): Int {
        return _pieces.getScore(team)
    }

    fun move(sourcePosition: Position, targetPosition: Position, team: Piece.Team = Piece.Team.WHITE) {
        val sourcePiece = findPieceIt(sourcePosition)
        val targetPiece = findPieceIt(targetPosition)
        checkPosition(sourcePosition, targetPosition)
        checkPiece(sourcePiece, targetPiece)
        checkTurn(team, sourcePiece.team)
        checkAbleMove(sourcePiece, sourcePosition, targetPosition)
    }

    private fun checkPosition(sourcePosition: Position, targetPosition: Position) {
        if (sourcePosition == targetPosition) {
            throw RuntimeException("자기 위치로는 움직일 수 없습니다.")
        }
    }

    private fun checkPiece(sourcePiece: Piece, targetPiece: Piece) {
        if (sourcePiece.type == Piece.Type.EMPTY) {
            throw RuntimeException("비어있는 칸은 움직일수 없습니다.")
        }
        if (sourcePiece.team == targetPiece.team) {
            throw RuntimeException("자기 팀이 있는 위치로는 움직일 수 없습니다.")
        }
    }

    private fun checkTurn(currentTurn: Piece.Team, sourceTeam: Piece.Team) {
        if (currentTurn != sourceTeam) {
            throw RuntimeException("${sourceTeam.value} 의 차례가 아닙니다.")
        }
    }

    private fun checkAbleMove(sourcePiece: Piece, sourcePosition: Position, targetPosition: Position) {
        if (sourcePiece.ableMoveIt(sourcePosition, targetPosition)) {
            _points.addIt(targetPosition.column, targetPosition.raw, sourcePiece)
            _points.deleteIt(sourcePosition.column, sourcePosition.raw)
        } else {
            throw RuntimeException("해당 말은 움직일 수 없는 위치 입니다.")
        }
    }

    fun findPieceIt(position: Position): Piece {
        return _points.findIt(position.column, position.raw)
    }

    fun getPiecesList(): List<List<Piece>> {
        return _points.mapToList()
    }

    companion object {
        const val BLACK_FRONT_LINE = 2
        const val BLACK_BACK_LINE = 1
        const val WHITE_FRONT_LINE = 7
        const val WHITE_BACK_LINE = 8
        const val COLUMN_LENGTH = 8
        const val RAW_LENGTH = 8
        const val ROOK = 1
        const val KNIGHT = 2
        const val BISHOP = 3
        const val QUEEN = 4
        const val KING = 5
        val COLUMN_RANGE = 1..8
        val RAW_RANGE = 1..8

        fun toPosition(stringPosition: String): Position = Position(stringPosition)
    }
}
