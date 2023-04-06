package chess.board.domain

import chess.piece.domain.Bishop
import chess.piece.domain.King
import chess.piece.domain.Knight
import chess.piece.domain.Pawn
import chess.piece.domain.Piece
import chess.piece.domain.Queen
import chess.piece.domain.Rook
import chess.piece.domain.Team

class Points {
    private var points: Map<File, MutableMap<Rank, Piece?>> = mapOf()

    fun init() {
        points = INITIALIZED_BOARD.map { it.key to it.value.toMutableMap() }.toMap()
    }

    fun find(coordinate: Coordinate): Piece? {
        val ranks = points[coordinate.file] ?: return null

        return ranks[coordinate.rank]
    }

    companion object {
        private val TEAM =
            mapOf(Rank.ONE to Team.WHITE, Rank.TWO to Team.WHITE, Rank.SEVEN to Team.BLACK, Rank.EIGHT to Team.BLACK)
        val INITIALIZED_BOARD: Map<File, Map<Rank, Piece?>> = setFiles()

        private fun setFiles(): Map<File, Map<Rank, Piece?>> {
            return File.values().associateWith { setRanks(it) }
        }

        private fun setRanks(file: File): Map<Rank, Piece?> {
            return Rank.values().associateWith { makePiece(file, it) }
        }

        private fun makePiece(file: File, rank: Rank): Piece? {
            val team = TEAM[rank] ?: return null

            if (Rank.containsPawnRanks(rank)) {
                return Pawn(team)
            }
            if (File.containsRookFiles(file)) {
                return Rook(team)
            }
            if (File.containsKnightFiles(file)) {
                return Knight(team)
            }
            if (File.containsBishopFiles(file)) {
                return Bishop(team)
            }
            if (file.isQueenFile()) {
                return Queen(team)
            }
            if (file.isKingFile()) {
                return King(team)
            }
            return null
        }
    }
}
