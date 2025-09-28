# Unit Converter App - Android EE408

An elegant Android unit conversion application built with Jetpack Compose, demonstrating modern Android development practices and UI design principles for the EE 408 - Software Design for Visual Environments course at Clarkson University.

## 🎯 Project Overview

This Unit Converter App is a comprehensive Android application that showcases fundamental concepts in software design for visual environments. The app provides intuitive unit conversions across multiple categories with a beautiful, responsive user interface built using Jetpack Compose.

### ✨ Key Features

- **Multiple Conversion Categories**:
  - **Speed**: Miles per hour ⇄ Kilometers per hour
  - **Mass**: Kilograms ⇄ Pounds  
  - **Temperature**: Celsius ⇄ Fahrenheit

- **Modern UI/UX**:
  - Beautiful gradient backgrounds
  - Material Design 3 components
  - Responsive button highlighting
  - Real-time conversion calculations
  - Intuitive category-based layout

- **Smart Input Handling**:
  - Numeric keyboard for easy data entry
  - Real-time validation and error messaging
  - Formatted results with 2 decimal precision
  - Graceful handling of invalid input

## 🏗️ Technical Architecture

### Technology Stack
- **Language**: Kotlin 2.0.21
- **UI Framework**: Jetpack Compose (BOM 2024.09.00)
- **Architecture**: Component-based declarative UI
- **Build System**: Gradle with Kotlin DSL
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 36 (Android 14+)

### Key Components
- **MainActivity**: Main entry point using ComponentActivity
- **UnitConverter**: Primary composable managing conversion logic
- **CategorySection**: Reusable component for conversion category buttons
- **Gradient Backgrounds**: Custom visual styling with color gradients
- **State Management**: Reactive UI with `remember` and `mutableStateOf`


## 🚀 Getting Started

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

1. **Launch the App**: Open the Unit Converter on your device/emulator
2. **Enter Value**: Type the number you want to convert in the input field
3. **Select Category**: Choose from Speed, Mass, or Temperature sections
4. **Pick Conversion**: Tap the desired conversion button (e.g., "mph → kph")
5. **View Result**: The converted value appears instantly below with proper formatting
6. **Switch Conversions**: Easily change between different unit types in real-time

### Project Structure
```
Android-EE408/
├── README.md                          # Project documentation
├── app/                              # Main application module
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/unitconverterapp/
│   │   │   │   ├── MainActivity.kt    # Main activity with Compose UI
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

### Testing Strategy
- **Unit Tests**: Core conversion logic validation
- **UI Tests**: Compose UI interaction testing  
- **Integration Tests**: End-to-end conversion workflows
- **Manual Testing**: Device compatibility and user experience validation


### Code Quality Standards
- Follow [Android Kotlin Style Guide](https://developer.android.com/kotlin/style-guide)
- Use meaningful variable and function names
- Maintain comprehensive code comments
- Organize code into logical, reusable components
- Consistent 4-space indentation

## 🔍 Troubleshooting

### Common Issues

1. **Gradle Build Issues**
   - Sync project: `File > Sync Project with Gradle Files`
   - Clean and rebuild: `Build > Clean Project` → `Build > Rebuild Project`
   - Check internet connection for dependency downloads

2. **Emulator Performance**
   - Allocate minimum 4GB RAM to AVD
   - Enable hardware acceleration (HAXM/WHPX)
   - Use x86_64 images for better performance

3. **Compose Preview Issues**
   - Ensure latest Android Studio version
   - Invalidate caches: `File > Invalidate Caches and Restart`
   - Check Compose compiler version compatibility

## 📚 Learning Resources

### Android Development
- [Android Developer Documentation](https://developer.android.com/docs)
- [Jetpack Compose Tutorial](https://developer.android.com/jetpack/compose/tutorial)
- [Material Design 3](https://m3.material.io/)
- [Kotlin Language Guide](https://kotlinlang.org/docs/reference/)

### Course-Specific Resources
- [Android Codelabs](https://codelabs.developers.google.com/?cat=Android)
- [Compose Pathway](https://developer.android.com/courses/pathways/compose)
- [UI Design Principles](https://developer.android.com/design)

## 📄 License & Academic Integrity

This project is developed for educational purposes as part of EE 408 coursework at Clarkson University. Students should:

- Follow Clarkson University's academic integrity policies
- Use this code as a reference for learning concepts
- Avoid direct copying for submitted assignments
- Properly cite any code adaptations or inspirations

---

