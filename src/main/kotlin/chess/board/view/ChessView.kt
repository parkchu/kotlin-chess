package chess.board.view

import chess.line.domain.Line
import chess.piece.domain.Piece

object ChessView {

    fun print(piecesList: List<List<Piece>>): String {
        val line = Line()
        piecesList.forEach {
            pieceToString(it, line)
        }
        println(line.string)
        return line.string
    }

    private fun pieceToString(rawPieces: List<Piece>, line: Line) {
        val string = rawPieces.joinToString(separator = "", transform = { piece -> piece.print() })
        line.add(string)
    }
}
