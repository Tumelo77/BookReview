package com.example.bookreview

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class DetailedViewActivity : AppCompatActivity() {

    // Declare arrays to receive data from MainActivity
    private lateinit var bookTitles: ArrayList<String>
    private lateinit var bookAuthors: ArrayList<String>
    private lateinit var bookRatings: ArrayList<Int>
    private lateinit var bookComments: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        // Receive data from MainActivity with error handling
        try {
            bookTitles = intent.getStringArrayListExtra("titles") ?: ArrayList()
            bookAuthors = intent.getStringArrayListExtra("authors") ?: ArrayList()
            bookRatings = intent.getIntegerArrayListExtra("ratings") ?: ArrayList()
            bookComments = intent.getStringArrayListExtra("comments") ?: ArrayList()
        } catch (e: Exception) {
            showError("Error loading book data: ${e.message}")
            finish()
            return
        }

        // Initialize buttons
        val btnDisplayBooks: Button = findViewById(R.id.btnDisplayBooks)
        val btnCalculateAverage: Button = findViewById(R.id.btnCalculateAverage)
        val btnBackToMain: Button = findViewById(R.id.btnBackToMain)

        // Button 1: Display all books with details using a loop
        btnDisplayBooks.setOnClickListener {
            displayAllBooks()
        }

        // Button 2: Calculate and display average rating using a loop
        btnCalculateAverage.setOnClickListener {
            calculateAverageRating()
        }

        // Button 3: Return to main screen
        btnBackToMain.setOnClickListener {
            finish()
        }
    }

    /**
     * Displays all books with their details using a loop
     * Demonstrates array traversal and string building
     */
    private fun displayAllBooks() {
        try {
            // Error handling: Check if there are any books
            if (bookTitles.isEmpty()) {
                showError("No books available. Please add some books first.")
                return
            }

            // Build a string with all book details using a loop
            val booksList = StringBuilder()
            booksList.append("📚 Book Reviews:\n")
            booksList.append("─────────────────────\n\n")

            // Loop through all books and display their details
            for (i in bookTitles.indices) {
                try {
                    booksList.append("Book ${i + 1}:\n")
                    booksList.append("Title: ${bookTitles[i]}\n")
                    booksList.append("Author: ${bookAuthors[i]}\n")
                    booksList.append("Rating: ${bookRatings[i]}/5 ${"⭐".repeat(bookRatings[i])}\n")
                    booksList.append("Comment: ${bookComments[i]}\n")
                    booksList.append("\n─────────────────────\n\n")
                } catch (e: IndexOutOfBoundsException) {
                    // Error handling: Array index mismatch
                    showError("Data inconsistency detected at book ${i + 1}")
                    break
                }
            }

            // Display the list in a dialog
            AlertDialog.Builder(this)
                .setTitle("All Books (${bookTitles.size} total)")
                .setMessage(booksList.toString())
                .setPositiveButton("OK", null)
                .show()

        } catch (e: Exception) {
            // Error handling: Unexpected error
            showError("An error occurred while displaying books: ${e.message}")
        }
    }

    /**
     * Calculates and displays the average rating of all books
     * Uses a loop to sum all ratings
     */
    private fun calculateAverageRating() {
        try {
            // Error handling: Check if there are any books
            if (bookRatings.isEmpty()) {
                showError("No books available to calculate average. Please add some books first.")
                return
            }

            // Calculate sum using a loop
            var totalRating = 0
            for (rating in bookRatings) {
                totalRating += rating
            }

            // Calculate average
            val averageRating = totalRating.toDouble() / bookRatings.size

            // Build detailed statistics message
            val statsMessage = buildString {
                append("📊 Rating Statistics:\n\n")
                append("Total Books: ${bookRatings.size}\n")
                append("Total Rating Points: $totalRating\n")
                append("Average Rating: ${"%.2f".format(averageRating)}/5\n\n")

                // Add visual representation
                val stars = (averageRating.toInt()).coerceIn(1, 5)
                append("Visual: ${"⭐".repeat(stars)}\n\n")

                // Show rating distribution
                append("Rating Distribution:\n")
                for (rating in 1..5) {
                    val count = bookRatings.count { it == rating }
                    if (count > 0) {
                        append("$rating stars: $count book(s)\n")
                    }
                }
            }

            // Display the average in a dialog
            AlertDialog.Builder(this)
                .setTitle("Average Rating")
                .setMessage(statsMessage)
                .setPositiveButton("OK", null)
                .show()

            // Also show a quick toast
            Toast.makeText(
                this,
                "Average: ${"%.2f".format(averageRating)}/5",
                Toast.LENGTH_LONG
            ).show()

        } catch (e: ArithmeticException) {
            // Error handling: Division error
            showError("Calculation error: ${e.message}")
        } catch (e: Exception) {
            // Error handling: Unexpected error
            showError("An error occurred while calculating average: ${e.message}")
        }
    }

    /**
     * Displays error messages to the user
     * @param message The error message to display
     */
    private fun showError(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}