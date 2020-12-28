package chess.piece.domain

class Pieces {
    private val _blackPieces: MutableList<Piece> = mutableListOf()
    private val _whitePieces: MutableList<Piece> = mutableListOf()

    fun addPieceOfTeam(piece: Piece) {
        if (piece.isBlack()) {
            _blackPieces.add(piece)
        }
        if (piece.isWhite()) {
            _whitePieces.add(piece)
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
}
