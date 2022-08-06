enum class Rainbow(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet")
}

fun main() {
    val color = readln()
    // put your code here
    println(Rainbow.valueOf(color.uppercase()).ordinal + 1)
}