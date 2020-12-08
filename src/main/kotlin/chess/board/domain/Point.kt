package chess.board.domain

class Point(x: String, val y: Int) {
    val x: CoordinateX = getCoordinate(x)

    private fun getCoordinate(x: String): CoordinateX {
        return when (x) {
            "a" -> CoordinateX.A
            "b" -> CoordinateX.B
            "c" -> CoordinateX.C
            "d" -> CoordinateX.D
            "e" -> CoordinateX.E
            "f" -> CoordinateX.F
            "g" -> CoordinateX.G
            "h" -> CoordinateX.H
            else -> throw RuntimeException()
        }
    }
}
