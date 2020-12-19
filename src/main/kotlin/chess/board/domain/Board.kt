package chess.board.domain

import chess.line.domain.Line
import chess.piece.domain.Piece

class Board {
    private val _pieces: Map<Int, MutableMap<String, Piece>> = makeMap()

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
        val rawPieces = _pieces[raw] ?: throw RuntimeException("해당 위치는 보드에 없다")
        rawPieces.forEach { rawPieces[it.key] = piece }
    }

    private fun setPieces() {
        val rawBlackPieces = _pieces[1] ?: throw RuntimeException("해당 위치는 보드에 없다")
        val rawWhitePieces = _pieces[8] ?: throw RuntimeException("해당 위치는 보드에 없다")
        COLUMN.forEach { setPiece(it, rawBlackPieces, rawWhitePieces) }
    }

    private fun setPiece(column: String, rawBlackPieces: MutableMap<String, Piece>, rawWhitePieces: MutableMap<String, Piece>) {
        if (column == "a" || column == "h") {
            rawBlackPieces[column] = Piece.BLACK_ROOK
            rawWhitePieces[column] = Piece.WHITE_ROOK
        } else if (column == "b" || column == "g") {
            rawBlackPieces[column] = Piece.BLACK_KNIGHT
            rawWhitePieces[column] = Piece.WHITE_KNIGHT
        } else if (column == "c" || column == "f") {
            rawBlackPieces[column] = Piece.BLACK_BISHOP
            rawWhitePieces[column] = Piece.WHITE_BISHOP
        } else if (column == "d") {
            rawBlackPieces[column] = Piece.BLACK_QUEEN
            rawWhitePieces[column] = Piece.WHITE_QUEEN
        } else if (column == "e") {
            rawBlackPieces[column] = Piece.BLACK_KING
            rawWhitePieces[column] = Piece.WHITE_KING
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

    companion object {
        val COLUMN = listOf("a", "b", "c", "d", "e", "f", "g", "h")
    }
}
