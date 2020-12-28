package chess.point.domain

import chess.piece.domain.Piece

class Points(column: Int, raw: Int) {
    private val _points: Map<Int, MutableMap<Int, Piece>> = makeMap(column, raw)

    private fun makeMap(column: Int, raw: Int): Map<Int, MutableMap<Int, Piece>> {
        val mutableMap = mutableMapOf<Int, MutableMap<Int, Piece>>()
        repeat(raw) {
            mutableMap[it + 1] = makeColumn(column)
        }
        return mutableMap
    }

    private fun makeColumn(column: Int): MutableMap<Int, Piece> {
        val smallMap = mutableMapOf<Int, Piece>()
        repeat(column) {
            smallMap[it + 1] = Piece.EMPTY
        }
        return smallMap
    }

    fun mapToList(): List<List<Piece>> = _points.map { pieces -> pieces.value.map { it.value } }

    fun addIt(column: Int, raw: Int, piece: Piece) {
        val rawPieces = getRawPieces(raw)
        rawPieces[column] ?: throw IllegalArgumentException("존재하지 않는 위치입니다.")
        rawPieces[column] = piece
    }

    private fun getRawPieces(raw: Int): MutableMap<Int, Piece> {
        return _points[raw] ?: throw IllegalArgumentException("존재하지 않는 위치입니다.")
    }

    fun findIt(column: Int, raw: Int): Piece {
        val rawPieces = getRawPieces(raw)
        return rawPieces[column] ?: throw IllegalArgumentException("존재하지 않는 위치입니다.")
    }

    fun deleteIt(column: Int, raw: Int) {
        val rawPieces = getRawPieces(raw)
        rawPieces[column] ?: throw IllegalArgumentException("존재하지 않는 위치입니다.")
        rawPieces[column] = Piece.EMPTY
    }
}
