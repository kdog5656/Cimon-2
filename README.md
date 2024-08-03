# CIMON: Color Memory Game

CIMON is an Android application that implements a color memory game similar to Simon. 
Players must remember and repeat a sequence of colors that gets progressively longer.

## Features

- Interactive color buttons (Red, Yellow, Purple, Blue)
- Randomly generated color sequences
- Increasing difficulty as the game progresses
- Immediate feedback on player performance
- Integration with Firebase Realtime Database

## Getting Started

### Prerequisites

- Android Studio
- Android SDK
- Firebase account and project set up

### Installation

1. Clone the repository
2. Open the project in Android Studio
3. Connect the app to your Firebase project by adding the `google-services.json` file to the app directory
4. Build and run the application on an emulator or physical device

## How to Play

1. Launch the app and press the "Start" button on the main screen
2. Watch the sequence of colors as they flash
3. Repeat the sequence by tapping the colored buttons in the correct order
4. Press the "Done" button when you've finished your sequence
5. If correct, the game will add another color to the sequence
6. Continue playing until you make a mistake

## Project Structure

- `MainActivity.kt`: Handles the main screen and Firebase initialization
- `GamePageActivity.kt`: Contains the main game logic, including:
  - Generating and displaying color sequences
  - Handling user input
  - Comparing user input to the generated sequence
  - Managing game rounds

## Technologies Used

- Kotlin
- Android SDK
- Firebase Realtime Database
