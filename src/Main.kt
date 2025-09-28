import kotlin.random.Random

interface GOLBase {
    fun step()
    fun isDead(): Boolean
}

abstract class GOLBaseChar(val width: Int, val height: Int) : GOLBase {
    abstract var board: MutableList<MutableList<Char>>
}

class GOL(width: Int, height: Int, initialBoard: List<String>? = null)
    : GOLBaseChar(width, height) {
    override var board: MutableList<MutableList<Char>>
    private var generation = 0

    init {
        board = if (initialBoard != null) {
            initialBoard.map { it.toMutableList() }.toMutableList()
        } else {
            MutableList(height) {
                MutableList(width) { if (Random.nextFloat() < 0.3) '#' else ' ' }
            }
        }
    }

    fun getGeneration(): Int = generation

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Generation: $generation\n")
        builder.append('+')
        builder.append("-".repeat(width))
        builder.append("+\n")
        for (row in board) {
            builder.append('|')
            for (cell in row) {
                builder.append(cell)
            }
            builder.append("|\n")
        }
        builder.append('+')
        builder.append("-".repeat(width))
        builder.append("+\n")
        return builder.toString()
    }

    override fun isDead(): Boolean {
        return board.all { row -> row.all { it == ' ' } }
    }

    override fun step() {
        val nextBoard = MutableList(height) { MutableList(width) { ' ' } }
        for (y in 0 until height) {
            for (x in 0 until width) {
                val liveNeighbors = countLiveNeighbors(x, y)
                val current = board[y][x]
                when (current) {
                    '#' -> nextBoard[y][x] =
                        if (liveNeighbors < 2 || liveNeighbors > 3) ' ' else '#'
                    ' ' -> if (liveNeighbors == 3) nextBoard[y][x] = '#'
                }
            }
        }
        board = nextBoard
        generation++
    }

    private fun countLiveNeighbors(x: Int, y: Int): Int {
        var count = 0
        val dx = listOf(-1, 0, 1, -1, 1, -1, 0, 1)
        val dy = listOf(-1, -1, -1, 0, 0, 1, 1, 1)

        for (i in dx.indices) {
            val nx = (x + dx[i] + width) % width
            val ny = (y + dy[i] + height) % height

            if (board[ny][nx] == '#') count++
        }
        return count
    }
}

// Terminal clearing
    // Method 1: ANSI escape sequences?
    fun clearScreen() {
        print("\u001B[2J\u001B[H")
    }
    // Method 2: Alternative ANSI clear
    // print("\u001B[2J\u001B[0;0H")
    // Method 3: Move cursor to top and clear
    // print("\u001B[H\u001B[2J")


fun combinePatterns(width: Int, height: Int, patterns: List<Pair<Int, List<String>>>): List<String> {
    val board = MutableList(height) { CharArray(width) { ' ' } }

    for ((offsetY, pattern) in patterns) {
        for (y in pattern.indices) {
            for (x in pattern[y].indices) {
                if (pattern[y][x] == '#' && y + offsetY < height && x < width) {
                    board[y + offsetY][x] = '#'
                }
            }
        }
    }
    return board.map { String(it) }
}

fun combinePatternsXY(width: Int, height: Int, patterns: List<Triple<Int, Int, List<String>>>): List<String> {
    val board = MutableList(height) { CharArray(width) { ' ' } }

    for ((offsetX, offsetY, pattern) in patterns) {
        for (y in pattern.indices) {
            for (x in pattern[y].indices) {
                if (pattern[y][x] == '#' && y + offsetY < height && x + offsetX < width) {
                    board[y + offsetY][x + offsetX] = '#'
                }
            }
        }
    }
    return board.map { String(it) }
}

fun main() {

    val block = listOf(
        "    ",
        " ## ",
        " ## ",
        "    "
    )
    val beehive = listOf(
        "      ",
        "  ##  ",
        " #  # ",
        "  ##  ",
        "      "
    )
    val loaf = listOf(
        "      ",
        "  ##  ",
        " #  # ",
        "  # # ",
        "   #  ",
        "      "
    )
    val boat = listOf(
        "     ",
        " ##  ",
        " # # ",
        "  #  ",
        "     "
    )
    val tub = listOf(
        "     ",
        "  #  ",
        " # # ",
        "  #  ",
        "     "
    )
    val glider = listOf(
        " #    ",
        "  #   ",
        "###   ",
        "      "
    )

    val blinker = listOf(
        "     ",
        " ### ",
        "     "
    )

    val patterns = combinePatternsXY(
        25, 15,
        listOf(
            Triple(2, 2, glider),
            Triple(15, 7, blinker),
            Triple(5, 10, glider)
        )
    )

    val game = GOL(30, 20,)

    println("\nStarting animation...")

    var steps = 0
    while(!game.isDead() && steps < 200) {

        //clearScreen();

        println(game)
        println("Step: $steps")

        // Advance generation
        game.step()
        steps++

        // Control animation speed
        Thread.sleep(100) // Time between frames
    }

    println("Simulation complete!")
}