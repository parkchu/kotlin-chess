package chess.board.domain

import chess.line.domain.Line
import chess.piece.domain.Piece
import chess.point.domain.Points

class Board {
    private val _points: Points = Points(COLUMN_LENGTH, RAW_LENGTH)
    private val _blackPieces: MutableList<Piece> = mutableListOf()
    private val _whitePieces: MutableList<Piece> = mutableListOf()

    fun init() {
        setPawnAllRaw(BLACK_FRONT_LINE, Piece.BLACK_PAWN)
        setPawnAllRaw(WHITE_FRONT_LINE, Piece.WHITE_PAWN)
        setPieces() // 폰을 제외한 나머지 말들 세팅
    }

    private fun setPawnAllRaw(raw: Int, piece: Piece) {
        repeat(COLUMN_LENGTH) {
            _points.addIt(it + 1, raw, piece)
            addPieceOfTeam(piece)
        }
    }

    private fun setPieces() {
        val rawBlackPieces = _points.getRawPieces(BLACK_BACK_LINE)
        val rawWhitePieces = _points.getRawPieces(WHITE_BACK_LINE)
        repeat(COLUMN_LENGTH) { setPiece(it + 1, rawBlackPieces, rawWhitePieces) }
    }

    private fun setPiece(column: Int, rawBlackPieces: MutableMap<Int, Piece>, rawWhitePieces: MutableMap<Int, Piece>) {
        if (column == 1 || column == 8) {
            rawBlackPieces[column] = Piece.BLACK_ROOK
            rawWhitePieces[column] = Piece.WHITE_ROOK
            addPieceOfTeam(Piece.BLACK_ROOK)
            addPieceOfTeam(Piece.WHITE_ROOK)
        } else if (column == 2 || column == 7) {
            rawBlackPieces[column] = Piece.BLACK_KNIGHT
            rawWhitePieces[column] = Piece.WHITE_KNIGHT
            addPieceOfTeam(Piece.BLACK_KNIGHT)
            addPieceOfTeam(Piece.WHITE_KNIGHT)
        } else if (column == 3 || column == 6) {
            rawBlackPieces[column] = Piece.BLACK_BISHOP
            rawWhitePieces[column] = Piece.WHITE_BISHOP
            addPieceOfTeam(Piece.BLACK_BISHOP)
            addPieceOfTeam(Piece.WHITE_BISHOP)
        } else if (column == 4) {
            rawBlackPieces[column] = Piece.BLACK_QUEEN
            rawWhitePieces[column] = Piece.WHITE_QUEEN
            addPieceOfTeam(Piece.BLACK_QUEEN)
            addPieceOfTeam(Piece.WHITE_QUEEN)
        } else if (column == 5) {
            rawBlackPieces[column] = Piece.BLACK_KING
            rawWhitePieces[column] = Piece.WHITE_KING
            addPieceOfTeam(Piece.BLACK_KING)
            addPieceOfTeam(Piece.WHITE_KING)
        }
    }

    private fun addPieceOfTeam(piece: Piece) {
        if (piece.isBlack()) {
            _blackPieces.add(piece)
        }
        if (piece.isWhite()) {
            _whitePieces.add(piece)
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
        addPieceOfTeam(piece)
    }

    private fun checkColumn(column: Int) {
        if (column !in COLUMN_RANGE) {
            throw IllegalArgumentException()
        }
    }

    fun getPiecesNumber(piece: Piece): Int {
        val pieces = _blackPieces + _whitePieces
        return pieces.count { it.team == piece.team && it.type == piece.type }
    }

    fun getScore(team: Piece.Team): Int {
        return when (team) {
            Piece.Team.BLACK -> {
                _blackPieces.sumBy { it.type.score }
            }
            Piece.Team.WHITE -> {
                _whitePieces.sumBy { it.type.score }
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    companion object {
        const val BLACK_FRONT_LINE = 2
        const val BLACK_BACK_LINE = 1
        const val WHITE_FRONT_LINE = 7
        const val WHITE_BACK_LINE = 8
        const val COLUMN_LENGTH = 8
        const val RAW_LENGTH = 8
        val COLUMN_RANGE = 1..8

        fun toPosition(stringPosition: String): Position = Position(stringPosition)
    }
}
