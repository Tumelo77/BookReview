# BookReview
# 📚 Book Review Android App

A native Android application built with Kotlin that allows users to store book details, author names, ratings, and comments. This app demonstrates the use of arrays, loops, screen navigation, and comprehensive error handling.

## ✨ Features

### Main Screen
- *Add to Book Review Button*: Opens a dialog to enter book details (title, author, rating 1-5, comment)
- *Detailed View Button*: Navigates to the detailed view screen
- *Exit App Button*: Closes the application with confirmation

### Detailed View Screen
- *Display All Books Button*: Shows all books with their complete details using loops
- *Calculate Average Rating Button*: Computes and displays the average rating of all books using loops
- *Back to Main Screen Button*: Returns to the main screen

## 🎯 Requirements Met

### Q.1.1 Programming Standards (20 points)
✅ *Code Implementation*: Complete Android Studio project with GitHub integration
✅ *Variable Declaration*: Proper declaration of four parallel arrays (title, author, rating, comment)
✅ *Methods/Functions*: Multiple well-structured methods for each functionality
✅ *Error Handling*: Comprehensive error handling throughout the app
✅ *Code Quality*: Clear, concise source code with meaningful comments

### Q.1.2 Main Screen (20 points)
✅ *Add Book Button*: Full dialog implementation with input validation
✅ *Detailed View Button*: Proper navigation with data passing
✅ *Exit Button*: Graceful app exit with confirmation

### Q.1.3 Detailed View Screen (25 points)
✅ *Display Books Button*: Uses loops to display all book data
✅ *Calculate Average Button*: Uses loops to calculate average rating
✅ *Back Button*: Returns to main screen

## 🛠️ Technical Implementation

### Arrays Used
kotlin
private val bookTitles = mutableListOf<String>()
private val bookAuthors = mutableListOf<String>()
private val bookRatings = mutableListOf<Int>()
private val bookComments = mutableListOf<String>()


### Loops Implementation
- *For loop* in displayAllBooks(): Iterates through all books to display details
- *For loop* in calculateAverageRating(): Sums all ratings for average calculation
- *For loop* in rating distribution: Counts books at each rating level

### Error Handling
1. *Input Validation*: Checks for empty fields
2. *Number Validation*: Ensures rating is a valid integer
3. *Range Validation*: Verifies rating is between 1-5
4. *Array Consistency*: Handles potential index mismatches
5. *Exception Catching*: Try-catch blocks for unexpected errors
6. *User Feedback*: Clear error messages via dialogs

## 📁 Project Structure


BookReviewApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/bookreview/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   └── DetailedViewActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_detailed_view.xml
│   │   │   │   │   └── dialog_add_book.xml
│   │   │   │   └── values/
│   │   │   │       └── strings.xml
│   │   │   └── AndroidManifest.xml
│   │   └── build.gradle
│   └── build.gradle
├── gradle/
└── README.md


## 🚀 Setup Instructions

### Prerequisites
- Android Studio (latest version recommended)
- JDK 8 or higher
- Android SDK (API 24 or higher)
- Git

### Installation Steps

1. *Clone or Download the Repository*
   bash
   git clone https://github.com/yourusername/BookReviewApp.git
   cd BookReviewApp
   

2. *Open in Android Studio*
   - Launch Android Studio
   - Click "Open an Existing Project"
   - Navigate to the cloned folder and select it
   - Wait for Gradle sync to complete

3. *Configure Project Structure*
   
   Create the following directory structure:
   
   app/src/main/
   ├── java/com/example/bookreview/
   │   ├── MainActivity.kt
   │   └── DetailedViewActivity.kt
   ├── res/
   │   ├── layout/
   │   │   ├── activity_main.xml
   │   │   ├── activity_detailed_view.xml
   │   │   └── dialog_add_book.xml
   │   └── values/
   │       └── strings.xml
   └── AndroidManifest.xml
   

4. *Copy Files to Correct Locations*
   - Copy MainActivity.kt and DetailedViewActivity.kt to app/src/main/java/com/example/bookreview/
   - Copy all XML layout files to app/src/main/res/layout/
   - Copy strings.xml to app/src/main/res/values/
   - Copy AndroidManifest.xml to app/src/main/
   - Copy build.gradle to app/

5. *Sync Gradle Files*
   - Click "Sync Project with Gradle Files" in Android Studio
   - Wait for sync to complete

6. *Run the App*
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon)
   - Select your device/emulator
   - Wait for the app to install and launch

## 🎮 How to Use

### Adding a Book Review
1. Launch the app
2. Tap "Add to Book Review"
3. Fill in all fields:
   - Book Title
   - Author Name
   - Rating (1-5)
   - Your Comment
4. Tap "Add" to save

### Viewing All Books
1. Tap "Detailed View" from main screen
2. Tap "Display All Books"
3. View all book details in a scrollable dialog

### Calculating Average Rating
1. From Detailed View screen
2. Tap "Calculate Average Rating"
3. View statistics including:
   - Total number of books
   - Average rating
   - Rating distribution

## 🐛 Error Handling Features

The app includes robust error handling for:
- Empty input fields
- Invalid rating format
- Rating out of range (not 1-5)
- Navigation errors
- Data loading errors
- Array index mismatches
- Empty book list operations

## 📱 Supported Android Versions
- Minimum SDK: API 24 (Android 7.0)
- Target SDK: API 34 (Android 14)

## 🎨 UI Features
- Modern Material Design
- Color-coded buttons for easy identification
- Emoji icons for visual appeal
- Responsive layouts
- Clear error messages
- Toast notifications for quick feedback
- Scrollable dialogs for long content

## 🔧 Technologies Used
- *Language*: Kotlin
- *IDE*: Android Studio
- *UI Framework*: Android XML Layouts
- *Components*: Activities, AlertDialogs, Buttons, EditTexts
- *Data Structures*: Parallel Arrays (Lists)
- *Control Structures*: For loops, Try-Catch blocks

## 📊 Sample Data

You can test the app with these sample books:

| Title | Author | Rating | Comment |
|-------|--------|--------|---------|
| You Get Better with Love | Duduzile Ngwenya | 3 | Poetry |
| Onion Tears | Shubnum Khan | 1 | Fiction |
| The Hitchhiker's Guide to AI | Arthur Goldstuck | 2 | Academic |
| The Whistleblowers | Mandy Weiner | 2 | Exposes the danger of being a whistleblower |

## 🤝 Contributing
This is a student project. Feel free to fork and modify for your own learning.

## 📝 License
This project is created for educational purposes.

## 👨‍💻 Author
Created as part of an Android Development assignment demonstrating:
- Kotlin programming
- Array manipulation
- Loop implementation
- Error handling
- Screen navigation
- User interface design

## 📞 Support
If you encounter any issues:
1. Check that all files are in the correct directories
2. Ensure Gradle sync completed successfully
3. Verify Android SDK is properly installed
4. Try cleaning and rebuilding the project (Build > Clean Project, then Build > Rebuild Project)

## 🎓 Learning Outcomes
This project demonstrates understanding of:
- Native Android development with Kotlin
- Parallel array implementation
- Loop usage for data processing
- Comprehensive error handling
- Screen navigation and data passing
- User input validation
- Material Design principles
- Git version control

---
