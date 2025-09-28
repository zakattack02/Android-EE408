# EE 408 - Software Design for Visual Environments

This repository contains Android applications and projects developed for EE 408 - Software Design for Visual Environments course at Clarkson University.

## Course Information

- **Course**: EE 408 - Software Design for Visual Environments
- **Institution**: Clarkson University
- **Prerequisite**: EE 262
- **Recent Professor**: Anthony Dowling
- **Semester**: Fall 2025

## Course Description

This course is an introduction to object-oriented, event-driven windowing environments. The primary focus will be interface design and development, with an emphasis placed on the event-driven paradigm.

## Project Overview

This repository includes Android projects covering key concepts in software design for visual environments, including:

- **Interface Design and Development**: Creating intuitive and responsive user interfaces
- **Event-Driven Programming**: Implementing event handlers and user interaction patterns
- **Object-Oriented Design**: Applying OOP principles in visual environment development
- **Static and Dynamic Control Objects**: Working with UI components for system input and output
- **Virtual Functions**: Understanding polymorphism and inheritance in GUI frameworks
- **Multithread Programming**: Managing concurrent operations in visual applications
- **Code Synchronization and Locking**: Preventing race conditions and ensuring thread safety
- **Resource Sharing**: Managing shared resources between threads and components
- **Windowing Framework Investigation**: Deep dive into Android's underlying framework architecture

## Repository Structure

```
Android-EE408/
├── README.md                          # Main repository documentation
├── ConwaysGameOfLife/                # Project 1: Conway's Game of Life (Kotlin CLI)
│   ├── README.md                     # Project-specific documentation
│   ├── src/
│   │   └── main/
│   │       └── kotlin/               # Kotlin source files
│   │           └── Main.kt           # Main CLI application
│   ├── build.gradle.kts              # Project build configuration
│   └── [Additional Kotlin CLI files]
├── UnitConverterApp/                 # Project 2: Unit Converter App (Android)
│   ├── README.md                     # Project-specific documentation
│   ├── app/                         # Main application module
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/example/unitconverterapp/
│   │   │   │   │   ├── MainActivity.kt    # Main activity with Compose UI
│   │   │   │   │   └── ui/theme/         # App theming and colors
│   │   │   │   ├── res/                 # Android resources
│   │   │   │   └── AndroidManifest.xml   # App configuration
│   │   │   └── test/                    # Unit tests
│   │   └── build.gradle.kts             # Module build configuration
│   ├── build.gradle.kts                # Project build configuration
│   ├── gradle/
│   │   ├── libs.versions.toml          # Version catalog for dependencies
│   │   └── wrapper/                    # Gradle wrapper files
│   └── settings.gradle.kts             # Project settings
├── [Project3]/                       # Placeholder for future projects
│   ├── README.md                     # Project-specific documentation
│   └── [Additional project files]
```

## Prerequisites

### For All Projects
- **JDK**: Java Development Kit 11 or higher
- **Kotlin**: Latest stable version
- **Git**: For version control

### For Project 1 (Conway's Game of Life)
- **IntelliJ IDEA Ultimate**: Latest version (available free for students)
- **Gradle**: Build automation (bundled with IntelliJ)

### For Project 2+ (Android Projects)
- **Android Studio**: Latest stable version
- **Android SDK**: API level 24 (Android 7.0) or higher

## Getting Started

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/zakattack02/Android-EE408.git
   cd Android-EE408
   ```

2. **Open Project in IDE**
   
   **For Conway's Game of Life (Project 1):**
   - Launch IntelliJ IDEA Ultimate
   - Select "Open" and navigate to `ConwaysGameOfLife/` folder
   - Wait for Gradle sync to complete
   
   **For Unit Converter App (Project 2):**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to `UnitConverterApp/` folder
   - Wait for Gradle sync and indexing to complete

3. **Build and Run**
   
   **For Conway's Game of Life:**
   - In IntelliJ IDEA, navigate to `src/main/kotlin/Main.kt`
   - Click the green arrow next to `main()` function or use `Shift + F10`
   - Interact with the game through the console/terminal output
   
   **For Unit Converter App:**
   - Connect an Android device or start an emulator
   - Click the "Run" button or use `Shift + F10`
   - The app will install and launch on your device/emulator

### Development Environment

**Project 1 (Conway's Game of Life):**
- **IDE**: IntelliJ IDEA Ultimate
- **Language**: Kotlin (CLI)
- **Build System**: Gradle
- **Platform**: Desktop/Console application

**Project 2+ (Android Projects):**
- **IDE**: Android Studio
- **Language**: Kotlin (primary)
- **Build System**: Gradle with Kotlin DSL
- **Platform**: Android mobile applications
- **Version Control**: Git

## Projects

### Project 1: Conway's Game of Life

A Kotlin command-line implementation of Conway's Game of Life, demonstrating fundamental programming concepts and algorithmic thinking. This project explores cellular automata, grid-based simulations, and object-oriented design principles using IntelliJ IDEA Ultimate.


### Project 2: Unit Converter App

An elegant Android unit conversion application built with Jetpack Compose, demonstrating modern Android development practices and UI design principles. The app supports conversions for Speed (mph ⇄ kph), Mass (kg ⇄ lbs), and Temperature (Celsius ⇄ Fahrenheit) with a responsive, Material Design 3-based interface.

**Key Features:**
- Multiple conversion categories (Speed, Mass, Temperature)
- Real-time conversion calculations with formatted output
- Intuitive UI with gradient backgrounds and category-based layout
- Smart input handling with numeric keyboard and error messaging

**Technologies Used:**
- Android SDK (API 24+)
- Jetpack Compose (BOM 2024.09.00)
- Kotlin 2.0.21
- Gradle with Kotlin DSL

**Learning Objectives:**
- Modern Android development with Jetpack Compose
- Event-driven UI programming and state management
- Material Design 3 implementation
- Mobile app architecture and best practices

**Documentation**: See UnitConverterApp/README.md for detailed setup and usage instructions.

## Learning Objectives

Through these projects, students will learn:

- **Object-Oriented Design Principles**: Applying OOP concepts in visual environment development
- **Event-Driven Programming Paradigm**: Understanding and implementing event-driven architectures
- **Interface Design and Development**: Creating effective and user-friendly visual interfaces
- **Windowing Framework Mastery**: Thorough investigation of Android's underlying framework
- **Control Object Management**: Working with static and dynamic UI components for I/O operations
- **Virtual Functions and Polymorphism**: Advanced OOP concepts in GUI development
- **Multithreading in Visual Applications**: Implementing concurrent operations safely
- **Synchronization and Resource Management**: Preventing race conditions and managing shared resources
- **Performance Optimization**: Debugging and optimizing visual applications

## Documentation

- [Android Developer Documentation](https://developer.android.com/docs)
- [Kotlin Language Reference](https://kotlinlang.org/docs/reference/)
- [Material Design Guidelines](https://material.io/design)

## Troubleshooting

### Common Issues

1. **Gradle Build Issues**
   - Clean and rebuild the project: `Build > Clean Project` then `Build > Rebuild Project`
   - Check for correct Gradle and SDK versions

2. **Emulator Issues**
   - Ensure virtualization is enabled in BIOS
   - Allocate sufficient RAM to the emulator
   - Use x86 images for better performance

3. **Device Connection Issues**
   - Enable USB debugging on the device
   - Install proper USB drivers
   - Check ADB connection: `adb devices`

## Contributing

This repository is primarily for educational purposes. If you're a student in the course:

1. Fork the repository
2. Create a feature branch for your project/lab
3. Commit your changes with descriptive messages
4. Push to your fork
5. Submit assignments as directed by the instructor

## Code Style Guidelines

- Use meaningful variable and function names
- Add comments for complex logic
- Organize code into appropriate packages
- Use proper indentation and formatting

## Resources

### Learning Materials
- [Android Basics in Kotlin](https://developer.android.com/courses/android-basics-kotlin/course)
- [Android Codelabs](https://codelabs.developers.google.com/?cat=Android)
- [Kotlin Bootcamp for Programmers](https://developer.android.com/courses/kotlin-bootcamp/overview)

### Useful Tools
- [Android Studio Profiler](https://developer.android.com/studio/profile)
- [Layout Inspector](https://developer.android.com/studio/debug/layout-inspector)
- [Database Inspector](https://developer.android.com/studio/inspect/database)

## License

This project is for educational purposes as part of EE 408 coursework at Clarkson University. Please refer to Clarkson University's academic integrity policies regarding code sharing and collaboration.
