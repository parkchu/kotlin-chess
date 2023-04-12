package chess.game.domain.board

import kotlin.math.abs

data class Distance(
    val fileDistance: Int,
    val rankDistance: Int
) {
    val absoluteFileDistance: Int = abs(fileDistance)
    val absoluteRankDistance: Int = abs(rankDistance)

    fun isStationary(): Boolean = fileDistance == 0 && rankDistance == 0

    fun getFileDirection(): Int {
        if (fileDistance > 0) {
            return 1
        }
        if (fileDistance < 0) {
            return -1
        }
        return 0
    }

    fun getRankDirection(): Int {
        if (rankDistance > 0) {
            return 1
        }
        if (rankDistance < 0) {
            return -1
        }
        return 0
    }
}
