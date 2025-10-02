# Conway's Game of Life App- Android EE408

An interactive Android implementation of Conway's Game of Life built with Jetpack Compose, demonstrating modern Android development practices and cellular automata simulation for the EE 408 - Software Design for Visual Environments course at Clarkson University.

##  Project Overview

This Game of Life App is an engaging Android application that brings the famous cellular automaton to life on mobile devices. The app showcases fundamental concepts in software design for visual environments, featuring an interactive grid-based simulation with intuitive controls built using Jetpack Compose.

###  Key Features

- **Interactive Cellular Automaton**:
  - **Conway's Game of Life Rules**: Birth, survival, and death mechanics
  - **Clickable Grid**: Tap cells to toggle between alive and dead states
  - **Real-time Simulation**: Watch patterns evolve with automatic stepping

- **Dynamic Board Management**:
  - **Resizable Grid**: Adjust width and height
  - **Wraparound Edges**: Toroidal topology for seamless pattern behavior
  - **Generation Tracking**: Monitor simulation progress with generation counter

- **Intuitive Controls**:
  - **Play/Pause**: Start and stop automatic simulation
  - **Step Mode**: Manually advance one generation at a time  
  - **Clear Board**: Reset all cells to dead state
  - **Random Patterns**: Generate random starting configurations
  - **Speed Control**: Adjustable simulation speed (1-10 steps/second)

##  Technical Architecture

### Technology Stack
- **Language**: Kotlin 2.0.21
- **UI Framework**: Jetpack Compose (BOM 2024.09.00)
- **Architecture**: Component-based declarative UI with state management
- **Build System**: Gradle with Kotlin DSL
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 36 (Android 14+)
- **Icons**: Material Icons Extended for UI controls

### Key Components
- **MainActivity**: Main entry point with edge-to-edge display support
- **SimpleGOL**: Core game logic class implementing Conway's rules
- **SimpleGameOfLifeScreen**: Primary composable managing game state and UI
- **LazyVerticalGrid**: Efficient grid rendering for cellular automaton
- **Coroutines**: Smooth animation timing with `LaunchedEffect` and `delay`
- **State Management**: Reactive UI updates with `remember` and `mutableStateOf`


##  Getting Started

### Prerequisites
- **Android Studio**: Latest stable version (Hedgehog 2023.1.1+)
- **JDK**: Java 11 or higher
- **Android SDK**: API 24+ installed
- **Kotlin**: 2.0.21 (managed by project)

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/zakattack02/Android-EE408.git
   cd Android-EE408
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned repository folder
   - Wait for Gradle sync to complete

3. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`
   - The app will install and launch automatically

## 📱 Usage Instructions

1. **Launch the App**: Open Conway's Game of Life on your device/emulator
2. **Create Patterns**: Tap individual cells on the grid to toggle them alive (black) or dead (white)
3. **Start Simulation**: Press "Play" to begin automatic evolution of your cellular pattern
4. **Control Playback**: Use "Pause" to stop, "Step" to advance one generation manually
5. **Modify Board**: 
   - Adjust grid size with "- Width/+ Width" and "- Height/+ Height" buttons
   - Use "Clear" to reset the board or "Random" to generate a random pattern
6. **Speed Control**: Use the slider to adjust simulation speed from slow to fast
7. **Monitor Progress**: Watch the generation counter to track simulation evolution

### Project Structure
```
Android-EE408/
├── README.md                          # Project documentation
├── app/                              # Main application module
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/gameoflifeapp/
│   │   │   │   ├── MainActivity.kt    # Game logic and Compose UI
│   │   │   │   └── ui/theme/         # App theming and colors
│   │   │   ├── res/                  # Android resources
│   │   │   └── AndroidManifest.xml   # App configuration
│   │   └── test/                     # Unit tests
│   └── build.gradle.kts              # Module build configuration
├── build.gradle.kts                  # Project build configuration
├── gradle/
│   ├── libs.versions.toml           # Version catalog for dependencies
│   └── wrapper/                     # Gradle wrapper files
└── settings.gradle.kts              # Project settings
```

## 🧪 Testing & Quality Assurance

### Game Rules Implementation
Conway's Game of Life follows these simple rules:
1. **Birth**: Dead cell with exactly 3 live neighbors becomes alive
2. **Survival**: Live cell with 2 or 3 live neighbors stays alive  
3. **Death**: Live cell with fewer than 2 or more than 3 neighbors dies
4. **Toroidal Grid**: Edges wrap around (top↔bottom, left↔right)

### Testing Strategy
- **Game Logic Tests**: Cellular automaton rule validation
- **UI Interaction Tests**: Grid cell toggling and control functionality
- **Performance Tests**: Large grid rendering and animation smoothness
- **Manual Testing**: Cross-device compatibility and user experience validation

##  Troubleshooting

### Common Issues

1. **Performance Issues**
   - Large grids (25x30+) may slow down on older devices
   - Reduce grid size or simulation speed for better performance
   - Close other apps to free up memory during intensive simulations

2. **Grid Display Problems**
   - Ensure device has sufficient screen space for grid rendering
   - Rotate device to landscape for better visibility on smaller screens
   - Adjust grid size if cells appear too small to interact with


##  Learning Resources

### Android Development
- [Android Developer Documentation](https://developer.android.com/docs)
- [Jetpack Compose Tutorial](https://developer.android.com/jetpack/compose/tutorial)
- [Material Design 3](https://m3.material.io/)
- [Kotlin Language Guide](https://kotlinlang.org/docs/reference/)

### Course-Specific Resources
- [Android Codelabs](https://codelabs.developers.google.com/?cat=Android)
- [Compose Pathway](https://developer.android.com/courses/pathways/compose)
- [UI Design Principles](https://developer.android.com/design)
- [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
- [Cellular Automata](https://mathworld.wolfram.com/CellularAutomaton.html)

##  License & Academic Integrity

This project is developed for educational purposes as part of EE 408 coursework at Clarkson University. Students should:

- Follow Clarkson University's academic integrity policies
- Use this code as a reference for learning concepts
- Avoid direct copying for submitted assignments
- Properly cite any code adaptations or inspirations

---
