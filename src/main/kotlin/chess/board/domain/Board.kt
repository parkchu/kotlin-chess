package chess.board.domain

import chess.line.domain.Line
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
        repeat(COLUMN_LENGTH) {
            _points.addIt(it + 1, raw, piece)
            _pieces.addPieceOfTeam(piece)
        }
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
        _points.addIt(column, raw, piece)
        _pieces.addPieceOfTeam(piece)
        if (column < 4) {
            _points.addIt(9 - column, raw, piece)
            _pieces.addPieceOfTeam(piece)
        }
    }

    fun print(): String {
        val line = Line()
        val piecesList = _points.mapToList()
        piecesList.forEach {
            pieceToString(it, line)
        }
        return line.string
    }

    private fun pieceToString(rawPieces: List<Piece>, line: Line) {
        val string = rawPieces.joinToString(separator = "", transform = { piece -> piece.print() })
        line.add(string)
    }

    fun findPieceIt(position: Position): Piece {
        return _points.findIt(position.column, position.raw)
    }

    fun addIt(position: Position, piece: Piece) {
        checkColumn(position.column)
        _points.addIt(position.column, position.raw, piece)
        _pieces.addPieceOfTeam(piece)
    }

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

        fun toPosition(stringPosition: String): Position = Position(stringPosition)
    }
}
