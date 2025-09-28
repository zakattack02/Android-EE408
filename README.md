# Conway's Game of Life - Kotlin CLI Implementation

A sophisticated Kotlin command-line implementation of Conway's Game of Life cellular automaton, demonstrating advanced object-oriented programming concepts, algorithmic thinking, and console-based visualization for EE 408 - Software Design for Visual Environments.

## 🎯 Project Overview

This project implements John Conway's famous "Game of Life" cellular automaton using modern Kotlin programming techniques. The simulation features a toroidal (wrap-around) grid where cells evolve according to Conway's rules, creating fascinating emergent patterns and behaviors.

### ✨ Key Features

- **Complete Conway's Rules Implementation**:
  - Live cells with 2-3 neighbors survive
  - Dead cells with exactly 3 neighbors become alive
  - All other cells die or remain dead

- **Advanced Object-Oriented Design**:
  - Interface-based architecture (`GOLBase`)
  - Abstract base classes (`GOLBaseChar`)
  - Clean separation of concerns and extensibility

- **Predefined Pattern Library**:
  - **Still Lifes**: Block, Beehive, Loaf, Boat, Tub
  - **Oscillators**: Blinker
  - **Spaceships**: Glider
  - **Pattern Combination System**: Mix multiple patterns on one grid

- **Interactive Console Visualization**:
  - Real-time ASCII animation in terminal
  - Generation tracking and display
  - Bordered grid display with clear formatting
  - Configurable animation speed

- **Smart Grid Management**:
  - Toroidal topology (edges wrap around)
  - Automatic dead-state detection
  - Efficient neighbor counting algorithm
  - Random initial state generation option

## 🏗️ Technical Architecture

### Key Design Patterns

- **Strategy Pattern**: Extensible through `GOLBase` interface
- **Template Method**: Abstract base class defines structure
- **Factory Pattern**: Multiple initialization options (random vs. patterns)
- **Builder Pattern**: Pattern combination utilities

### Algorithm Implementation

- **Efficient Neighbor Counting**: O(1) per cell using coordinate arrays
- **Toroidal Wrapping**: Modulo arithmetic for seamless edge behavior
- **Double Buffering**: Simultaneous evolution prevents cascading effects
- **State Management**: Clean generation tracking and termination detection

## 🚀 Getting Started

### Prerequisites

- **IntelliJ IDEA Ultimate** (free for students)
- **Kotlin** 1.8+ 
- **JDK** 11 or higher
- **Terminal/Console** with Unicode support

### Installation & Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/zakattack02/Android-EE408.git
   cd Android-EE408
   ```

2. **Open in IntelliJ IDEA**
   - Launch IntelliJ IDEA Ultimate
   - Select "Open" → Navigate to project folder
   - Wait for indexing and Gradle sync

3. **Run the Simulation**
   - Navigate to `src/Main.kt`
   - Click green arrow next to `main()` function
   - Or use keyboard shortcut: `Shift + F10`

### Basic Usage

The program runs automatically with predefined patterns:

```kotlin
val patterns = combinePatternsXY(
    25, 15,
    listOf(
        Triple(2, 2, glider),      // Glider at position (2,2)
        Triple(15, 7, blinker),    // Blinker at position (15,7)
        Triple(5, 10, glider)      // Second glider at (5,10)
    )
)
```

## 🎮 Customization Options

### Creating Custom Patterns

```kotlin
val myPattern = listOf(
    "     ",
    "  #  ",
    " ### ",
    "  #  ",
    "     "
)
```

### Adjusting Simulation Parameters

```kotlin
// Grid size
val game = GOL(width = 40, height = 25)

// Animation speed (milliseconds between frames)
Thread.sleep(150)

// Maximum generations
while (!game.isDead() && steps < 500)
```

### Random vs. Pattern Initialization

```kotlin
// Random initialization (30% alive probability)
val randomGame = GOL(30, 20)

// Pattern-based initialization
val patternGame = GOL(30, 20, myPatternList)
```

## 📊 Pattern Library

### Still Life Patterns (Stable)

| Pattern | Description | Size |
|---------|-------------|------|
| **Block** | 2×2 solid square | 4×4 |
| **Beehive** | Hexagonal structure | 6×5 |
| **Loaf** | Asymmetric stable form | 6×6 |
| **Boat** | Small stable vessel | 5×5 |
| **Tub** | Ring-like structure | 5×5 |

### Oscillating Patterns

| Pattern | Period | Description |
|---------|---------|-------------|
| **Blinker** | 2 | Horizontal ↔ Vertical line |

### Traveling Patterns (Spaceships)

| Pattern | Speed | Direction |
|---------|--------|-----------|
| **Glider** | 1/4 | Diagonal |

## 🔧 Advanced Features

### Pattern Combination System

```kotlin
// Combine patterns with Y-offset only
val simple = combinePatterns(width, height, listOf(
    Pair(5, glider),
    Pair(10, blinker)
))

// Combine patterns with X,Y positioning
val complex = combinePatternsXY(width, height, listOf(
    Triple(x, y, pattern1),
    Triple(x2, y2, pattern2)
))
```

### Terminal Control

```kotlin
// Clear screen for animation (may not work on all terminals)
clearScreen()  // Uses ANSI escape sequences
```

### Generation Tracking

```kotlin
val currentGen = game.getGeneration()
val isExtinct = game.isDead()
```

## 🎓 Learning Objectives Demonstrated

### Object-Oriented Programming
- **Inheritance**: Abstract classes and concrete implementations
- **Polymorphism**: Interface-based design for extensibility
- **Encapsulation**: Private methods and controlled state access
- **Abstraction**: Clean separation of game logic from display

### Algorithm Design
- **2D Grid Manipulation**: Efficient coordinate transformations
- **Neighbor Detection**: Optimized counting with boundary conditions
- **State Evolution**: Simultaneous multi-cell updates
- **Pattern Recognition**: Detecting stable and oscillating states

### Software Architecture
- **Modular Design**: Separate pattern definitions and game logic
- **Extensibility**: Easy addition of new patterns and rules
- **Configuration**: Parameterized grid sizes and timing
- **Debugging**: Generation tracking and state inspection

## 🔍 Code Analysis

### Performance Considerations
- **Time Complexity**: O(width × height) per generation
- **Space Complexity**: O(width × height) for double buffering
- **Memory Usage**: Efficient character-based storage
- **Animation Speed**: Configurable delay prevents excessive CPU usage

### Design Benefits
- **Maintainability**: Clear class hierarchy and method organization
- **Testability**: Interface-based design enables easy unit testing
- **Readability**: Well-named methods and logical code flow
- **Extensibility**: New patterns and rules easily added

## 🐛 Troubleshooting

### Common Issues

1. **Terminal Display Problems**
   ```bash
   # Ensure terminal supports Unicode
   # Try different terminal applications (iTerm2, Windows Terminal, etc.)
   ```

2. **Animation Too Fast/Slow**
   ```kotlin
   // Adjust sleep duration in main loop
   Thread.sleep(200)  // Slower animation
   Thread.sleep(50)   // Faster animation
   ```

3. **Pattern Not Displaying**
   ```kotlin
   // Check pattern coordinates are within grid bounds
   // Verify pattern strings use '#' for live cells
   ```

## 📚 Conway's Game of Life Rules

### The Four Rules
1. **Underpopulation**: Live cell with < 2 neighbors dies
2. **Survival**: Live cell with 2-3 neighbors survives  
3. **Overpopulation**: Live cell with > 3 neighbors dies
4. **Reproduction**: Dead cell with exactly 3 neighbors becomes alive

### Mathematical Interest
- **Turing Complete**: Can simulate any computation
- **Emergent Complexity**: Simple rules create complex behaviors
- **Zero-Player Game**: Evolution determined entirely by initial state
- **Cellular Automaton**: Example of discrete mathematical model

## 🔗 Extensions & Future Work

### Potential Enhancements
- **Interactive Mode**: Allow real-time pattern editing
- **File I/O**: Save/load patterns from files
- **Color Display**: Use ANSI colors for enhanced visualization
- **Statistics**: Track population, generations, pattern detection
- **GUI Version**: Swing or JavaFX implementation
- **Different Rules**: B3/S23 variations and other cellular automata

### Pattern Collections
- **Methuselahs**: Long-lived evolving patterns
- **Guns**: Patterns that create infinite streams of gliders
- **Puffers**: Moving patterns that leave debris trails
- **Gardens of Eden**: Patterns with no possible predecessors

## 📖 References

- **John Conway**: Original Game of Life creator
- **Martin Gardner**: Scientific American columns (1970)
- **LifeWiki**: Comprehensive pattern database
- **Cellular Automata Theory**: Mathematical foundations

## 📄 License

Educational project for EE 408 - Software Design for Visual Environments at Clarkson University. Created for learning object-oriented programming, algorithm design, and console application development.

---