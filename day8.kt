package aoc

fun solve08A(input: List<String>): Int {

    val totalCharacters = input.sumOf { it.length }

    val memoryCharacters = input.sumOf { it.memoryCount() }

    return totalCharacters - memoryCharacters
}

fun String.memoryCount(): Int {

    var escapedString = ""

    var escaping = false
    var skip = 0

    for (c in this.drop(1).dropLast(1)) {

        if (skip > 0) {
            skip--
            continue
        }

        if (!escaping) {
            if (c != '\\') escapedString += c
            else escaping = true
            continue
        }

        if (c != 'x') {
            escaping = false
            escapedString += c
        } else {
            escaping = false
            skip = 2
            escapedString += '\''
        }
    }

    return escapedString.length
}

fun solve08B(input: List<String>): Long {
    TODO()
}
