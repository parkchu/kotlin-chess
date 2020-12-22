package chess.board.domain

import chess.line.domain.Line
import chess.piece.domain.Piece

class Board {
    private val _pieces: Map<Int, MutableMap<String, Piece>> = makeMap()
    private val _blackPieces: MutableList<Piece> = mutableListOf()
    private val _whitePieces: MutableList<Piece> = mutableListOf()

    private fun makeMap(): Map<Int, MutableMap<String, Piece>> {
        val mutableMap = mutableMapOf<Int, MutableMap<String, Piece>>()
        repeat(8) {
            mutableMap[it + 1] = makeColumn()
        }
        return mutableMap
    }

    private fun makeColumn(): MutableMap<String, Piece> {
        val smallMap = mutableMapOf<String, Piece>()
        COLUMN.forEach {
            smallMap[it] = Piece.EMPTY
        }
        return smallMap
    }

    fun init() {
        setPawnAllRaw(2, Piece.BLACK_PAWN)
        setPawnAllRaw(7, Piece.WHITE_PAWN)
        setPieces() // 폰을 제외한 나머지 말들 세팅
    }

    private fun setPawnAllRaw(raw: Int, piece: Piece) {
        val rawPieces = getRawPieces(raw)
        rawPieces.forEach {
            rawPieces[it.key] = piece
            addPieceOfTeam(piece)
        }
    }

    private fun getRawPieces(raw: Int): MutableMap<String, Piece> {
        return _pieces[raw] ?: throw IllegalArgumentException()
    }

    private fun addPieceOfTeam(piece: Piece) {
        if (piece.isBlack()) {
            _blackPieces.add(piece)
        }
        if (piece.isWhite()) {
            _whitePieces.add(piece)
        }
    }

    private fun setPieces() {
        val rawBlackPieces = getRawPieces(1)
        val rawWhitePieces = getRawPieces(8)
        COLUMN.forEach { setPiece(it, rawBlackPieces, rawWhitePieces) }
    }

    private fun setPiece(column: String, rawBlackPieces: MutableMap<String, Piece>, rawWhitePieces: MutableMap<String, Piece>) {
        if (column == "a" || column == "h") {
            rawBlackPieces[column] = Piece.BLACK_ROOK
            rawWhitePieces[column] = Piece.WHITE_ROOK
            addPieceOfTeam(Piece.BLACK_ROOK)
            addPieceOfTeam(Piece.WHITE_ROOK)
        } else if (column == "b" || column == "g") {
            rawBlackPieces[column] = Piece.BLACK_KNIGHT
            rawWhitePieces[column] = Piece.WHITE_KNIGHT
            addPieceOfTeam(Piece.BLACK_KNIGHT)
            addPieceOfTeam(Piece.WHITE_KNIGHT)
        } else if (column == "c" || column == "f") {
            rawBlackPieces[column] = Piece.BLACK_BISHOP
            rawWhitePieces[column] = Piece.WHITE_BISHOP
            addPieceOfTeam(Piece.BLACK_BISHOP)
            addPieceOfTeam(Piece.WHITE_BISHOP)
        } else if (column == "d") {
            rawBlackPieces[column] = Piece.BLACK_QUEEN
            rawWhitePieces[column] = Piece.WHITE_QUEEN
            addPieceOfTeam(Piece.BLACK_QUEEN)
            addPieceOfTeam(Piece.WHITE_QUEEN)
        } else if (column == "e") {
            rawBlackPieces[column] = Piece.BLACK_KING
            rawWhitePieces[column] = Piece.WHITE_KING
            addPieceOfTeam(Piece.BLACK_KING)
            addPieceOfTeam(Piece.WHITE_KING)
        }
    }

    fun print(): String {
        val line = Line()
        val piecesList = mapToList()
        piecesList.forEach {
            pieceToString(it, line)
        }
        return line.string
    }

    private fun mapToList(): List<List<Piece>> = _pieces.map { pieces -> pieces.value.map { it.value } }

    private fun pieceToString(rawPieces: List<Piece>, line: Line) {
        val string = rawPieces.joinToString(separator = "", transform = { piece -> piece.print() })
        line.add(string)
    }

    fun findPieceIt(position: String): Piece {
        val column = position.first().toString()
        val raw = Character.getNumericValue(position.last())
        val rawPieces = getRawPieces(raw)
        return rawPieces[column] ?: throw IllegalArgumentException()
    }

    fun addIt(position: String, piece: Piece) {
        val column = checkColumn(position.first().toString())
        val raw = Character.getNumericValue(position.last())
        val rawPieces = getRawPieces(raw)
        rawPieces[column] = piece
        addPieceOfTeam(piece)
    }

    private fun checkColumn(column: String): String {
        if (COLUMN.contains(column)) {
            return column
        }
        throw IllegalArgumentException()
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
        val COLUMN = listOf("a", "b", "c", "d", "e", "f", "g", "h")
    }
}
