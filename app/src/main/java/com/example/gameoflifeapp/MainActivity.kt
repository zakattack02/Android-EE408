package com.example.gameoflifeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameoflifeapp.ui.theme.GameOfLifeAppTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

// Simple Game of Life class
class SimpleGOL(var width: Int, var height: Int) {
    var board: MutableList<MutableList<Boolean>>
    var generation = 0

    init {
        board = MutableList(height) { MutableList(width) { false } }
    }

    fun toggleCell(x: Int, y: Int) {
        if (x in 0 until width && y in 0 until height) {
            board[y][x] = !board[y][x]
        }
    }

    fun isCellAlive(x: Int, y: Int): Boolean {
        return if (x in 0 until width && y in 0 until height) {
            board[y][x]
        } else false
    }

    fun step() {
        val newBoard = MutableList(height) { MutableList(width) { false } }
        
        for (y in 0 until height) {
            for (x in 0 until width) {
                val neighbors = countNeighbors(x, y)
                val isAlive = board[y][x]
                
                newBoard[y][x] = when {
                    isAlive && (neighbors == 2 || neighbors == 3) -> true
                    !isAlive && neighbors == 3 -> true
                    else -> false
                }
            }
        }
        
        board = newBoard
        generation++
    }

    private fun countNeighbors(x: Int, y: Int): Int {
        var count = 0
        for (dy in -1..1) {
            for (dx in -1..1) {
                if (dx == 0 && dy == 0) continue
                val nx = (x + dx + width) % width
                val ny = (y + dy + height) % height
                if (board[ny][nx]) count++
            }
        }
        return count
    }

    fun clear() {
        board = MutableList(height) { MutableList(width) { false } }
        generation = 0
    }

    fun randomize() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                board[y][x] = Random.nextFloat() < 0.3
            }
        }
        generation = 0
    }

    fun resize(newWidth: Int, newHeight: Int) {
        val newBoard = MutableList(newHeight) { MutableList(newWidth) { false } }
        
        for (y in 0 until minOf(height, newHeight)) {
            for (x in 0 until minOf(width, newWidth)) {
                newBoard[y][x] = board[y][x]
            }
        }
        
        width = newWidth
        height = newHeight
        board = newBoard
    }

    fun copy(): SimpleGOL {
        val new = SimpleGOL(width, height)
        new.board = board.map { it.toMutableList() }.toMutableList()
        new.generation = generation
        return new
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameOfLifeAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    SimpleGameOfLifeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SimpleGameOfLifeScreen(modifier: Modifier = Modifier) {
    var game by remember { mutableStateOf(SimpleGOL(15, 10)) }
    var isPlaying by remember { mutableStateOf(false) }
    var speed by remember { mutableStateOf(500L) }

    // Auto-step when playing
    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            delay(speed)
            game.step()
            game = game.copy()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Simple header
        Text(
            text = "Game of Life - Generation: ${game.generation}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Board Size: ${game.width} x ${game.height}",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Simple game board - takes up available space above buttons
        val cellSize = maxOf(8.dp, 250.dp / maxOf(game.width, game.height))
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(game.width),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Takes up remaining space
                .border(2.dp, Color.Black),
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            itemsIndexed(
                items = (0 until game.height * game.width).toList()
            ) { _, index ->
                val x = index % game.width
                val y = index / game.width
                val isAlive = game.isCellAlive(x, y)
                
                Box(
                    modifier = Modifier
                        .size(cellSize)
                        .background(
                            color = if (isAlive) Color.Black else Color.White
                        )
                        .border(0.5.dp, Color.Gray)
                        .clickable { 
                            game.toggleCell(x, y)
                            game = game.copy()
                        }
                )
            }
        }

        // All controls pinned to bottom
        Column {
            // Play/Pause
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { 
                        isPlaying = !isPlaying
                        when (game.generation) {
                            0 -> {
                                game.randomize()
                                game = game.copy()
                            }
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(if (isPlaying) "Pause" else "Play")
                }
                Button(
                    onClick = { 
                        game.step()
                        game = game.copy()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Step")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Clear and Random
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        game.clear()
                        game = game.copy()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Clear")
                }
                Button(
                    onClick = {
                        game.randomize()
                        game = game.copy()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Random")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Size controls - Width
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                 Button(
                    onClick = { 
                        if (game.height < 99999) {
                            game.resize(game.width, game.height + 1)
                            game = game.copy()
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+ Height")
                }
                
                Button(
                    onClick = { 
                        if (game.width < 99999) {
                            game.resize(game.width + 1, game.height)
                            game = game.copy()
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+ Width")
                }
            }

            // Size controls - Height  
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { 
                        if (game.height > 5) {
                            game.resize(game.width, game.height - 1)
                            game = game.copy()
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("- Height")
                }
                Button(
                    onClick = { 
                        if (game.width > 5) {
                            game.resize(game.width - 1, game.height)
                            game = game.copy()
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("- Width")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Speed control
            Text("Speed: ${1000/speed} steps/sec")
            Slider(
                value = (1100f - speed.toFloat()),
                onValueChange = { speed = (1100f - it).toLong() },
                valueRange = 100f..1000f
            )
        }
    }
}