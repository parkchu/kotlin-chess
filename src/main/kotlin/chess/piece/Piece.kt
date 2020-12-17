package chess.piece

import chess.constant.PiecesPoint
import chess.constant.Team

interface Piece {
    val team: Team
    val value: PiecesPoint
}
