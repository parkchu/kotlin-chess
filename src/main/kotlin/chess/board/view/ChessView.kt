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

    fun printError(isPlaying: () -> Boolean): Boolean {
        return try {
            isPlaying()
        } catch (e: NoSuchElementException) {
            println("show, move .. .., restart, end 중에 입력해주세요")
            true
        } catch (e: Exception) {
            println(e.message ?: "위치를 잘 입력해주세요")
            true
        }
    }
}
