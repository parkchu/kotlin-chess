package chess.game.domain.board

data class Coordinate(
    val file: File,
    val rank: Rank
) {
    constructor(coordinate: String) : this(
        File.get(coordinate.first()),
        Rank.get(coordinate.last())
    )

    fun getDistance(targetCoordinate: Coordinate): Distance {
        val fileDistance = targetCoordinate.file.value - file.value
        val rankDistance = targetCoordinate.rank.value - rank.value

        return Distance(fileDistance, rankDistance)
    }

    fun move(right: Int, up: Int): Coordinate {
        return Coordinate(File.get(file.value + right), Rank.get(rank.value + up))
    }
}

enum class File(val value: Char) {
    A('a'),
    B('b'),
    C('c'),
    D('d'),
    E('e'),
    F('f'),
    G('g'),
    H('h');

    fun isKingFile() = E == this
    fun isQueenFile() = D == this

    companion object {
        fun get(value: Char) =
            values().find { it.value == value } ?: throw NoSuchElementException("해당 파일은 존재하지 않습니다. ($value)")

        fun containsRookFiles(file: File) = listOf(A, H).contains(file)
        fun containsKnightFiles(file: File) = listOf(B, G).contains(file)
        fun containsBishopFiles(file: File) = listOf(C, F).contains(file)
    }
}

enum class Rank(val value: Char) {
    ONE('1'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8');

    companion object {
        fun get(value: Char) =
            values().find { it.value == value} ?: throw NoSuchElementException("해당 랭크는 존재하지 않습니다. ($value)")

        fun containsPawnRanks(rank: Rank) = listOf(TWO, SEVEN).contains(rank)
    }
}
