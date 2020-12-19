package chess.line.domain

class Line {
    val string: String
        get() = _string

    private var _string: String = ""

    fun add(string: String) {
        if (_string.isBlank()) {
            _string = string
        } else {
            _string += "\n$string"
        }
    }
}
