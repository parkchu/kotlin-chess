package chess.game.domain.board

import chess.game.domain.piece.Bishop
import chess.game.domain.piece.King
import chess.game.domain.piece.Knight
import chess.game.domain.piece.Pawn
import chess.game.domain.piece.Piece
import chess.game.domain.piece.Queen
import chess.game.domain.piece.Rook
import chess.game.domain.piece.Team

class Board(
    private var points: Map<File, MutableMap<Rank, Piece?>> = mapOf()
) {
    fun init() {
        points = INITIALIZED_BOARD.map { it.key to it.value.toMutableMap() }.toMap()
    }

    fun find(coordinate: Coordinate): Piece? {
        val ranks = points[coordinate.file] ?: throw NoSuchElementException("존재하지 않는 파일 입니다. (${coordinate.file})")

        return ranks[coordinate.rank]
    }

    fun findNotNull(coordinate: Coordinate): Piece {
        return find(coordinate) ?: throw NoSuchElementException("해당 좌표에 기물이 없습니다. ($coordinate)")
    }

    fun move(currentCoordinate: Coordinate, targetCoordinate: Coordinate) {
        if (isImmovable(currentCoordinate, targetCoordinate)) {
            throw IllegalArgumentException("해당 좌표로 움직일 수 없습니다. ($targetCoordinate)")
        }
        val piece = findNotNull(currentCoordinate)

        setPiece(currentCoordinate, null)
        setPiece(targetCoordinate, piece)
    }

    private fun isImmovable(currentCoordinate: Coordinate, targetCoordinate: Coordinate): Boolean {
        val piece = findNotNull(currentCoordinate)
        val distance = currentCoordinate.getDistance(targetCoordinate)

        if (piece.isKnight() || isWithoutObstacle(currentCoordinate, targetCoordinate)) {
            return !(piece.isMovable(distance) && isMovable(targetCoordinate, piece.team))
        }
        return true
    }

    private fun isWithoutObstacle(currentCoordinate: Coordinate, targetCoordinate: Coordinate): Boolean {
        val distance = currentCoordinate.getDistance(targetCoordinate)
        val nextCoordinate = currentCoordinate.move(distance.getFileDirection(), distance.getRankDirection())

        if (nextCoordinate.getDistance(targetCoordinate).isImmovable()) {
            return true
        }
        find(nextCoordinate) ?: return isWithoutObstacle(nextCoordinate, targetCoordinate)
        return false
    }

    private fun isMovable(coordinate: Coordinate, team: Team): Boolean {
        val piece = find(coordinate)

        return piece == null || piece.isEnemy(team)
    }

    private fun setPiece(coordinate: Coordinate, piece: Piece?) {
        val ranks = points[coordinate.file] ?: throw NoSuchElementException("존재하지 않는 파일 입니다. (${coordinate.file})")

        ranks[coordinate.rank] = piece
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
