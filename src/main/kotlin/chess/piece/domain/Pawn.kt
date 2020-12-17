package chess.piece.domain

import chess.constant.PiecesPoint
import chess.constant.Team
import chess.piece.Piece

class Pawn(team: Team) : Piece(team) {
    val value: PiecesPoint = PiecesPoint.PAWN
}
