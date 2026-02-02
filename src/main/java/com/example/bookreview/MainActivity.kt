package com.example.bookreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare and initialize parallel arrays for book data
    private val bookTitles = mutableListOf<String>()
    private val bookAuthors = mutableListOf<String>()
    private val bookRatings = mutableListOf<Int>()
    private val bookComments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons
        val btnAddBook: Button = findViewById(R.id.btnAddBook)
        val btnDetailedView: Button = findViewById(R.id.btnDetailedView)
        val btnExit: Button = findViewById(R.id.btnExit)

        // Add Book button - shows dialog to enter book details
        btnAddBook.setOnClickListener {
            showAddBookDialog()
        }

        // Detailed View button - navigates to DetailedViewActivity
        btnDetailedView.setOnClickListener {
            navigateToDetailedView()
        }

        // Exit button - closes the app
        btnExit.setOnClickListener {
            exitApp()
        }
    }

    /**
     * Shows a dialog for adding a new book review
     * Includes input validation and error handling
     */
    private fun showAddBookDialog() {
        try {
            val dialogView = layoutInflater.inflate(R.layout.dialog_add_book, null)

            // Get references to input fields
            val etTitle: EditText = dialogView.findViewById(R.id.etTitle)
            val etAuthor: EditText = dialogView.findViewById(R.id.etAuthor)
            val etRating: EditText = dialogView.findViewById(R.id.etRating)
            val etComment: EditText = dialogView.findViewById(R.id.etComment)

            AlertDialog.Builder(this)
                .setTitle("Add Book Review")
                .setView(dialogView)
                .setPositiveButton("Add") { _, _ ->
                    // Validate and add book
                    val title = etTitle.text.toString().trim()
                    val author = etAuthor.text.toString().trim()
                    val ratingStr = etRating.text.toString().trim()
                    val comment = etComment.text.toString().trim()

                    // Error handling: Check if all fields are filled
                    if (title.isEmpty() || author.isEmpty() || ratingStr.isEmpty() || comment.isEmpty()) {
                        showError("All fields are required. Please fill in all book details.")
                        return@setPositiveButton
                    }

                    // Error handling: Validate rating is a number
                    val rating = try {
                        ratingStr.toInt()
                    } catch (e: NumberFormatException) {
                        showError("Rating must be a valid number.")
                        return@setPositiveButton
                    }

                    // Error handling: Validate rating is between 1-5
                    if (rating !in 1..5) {
                        showError("Rating must be between 1 and 5.")
                        return@setPositiveButton
                    }

                    // Add to parallel arrays
                    bookTitles.add(title)
                    bookAuthors.add(author)
                    bookRatings.add(rating)
                    bookComments.add(comment)

                    Toast.makeText(this, "Book added successfully!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel", null)
                .show()

        } catch (e: Exception) {
            // Error handling: Catch any unexpected errors
            showError("An error occurred while opening the dialog: ${e.message}")
        }
    }

    /**
     * Navigates to the Detailed View screen
     * Passes book data to the next activity
     */
    private fun navigateToDetailedView() {
        try {
            val intent = Intent(this, DetailedViewActivity::class.java)

            // Pass the arrays to DetailedViewActivity
            intent.putStringArrayListExtra("titles", ArrayList(bookTitles))
            intent.putStringArrayListExtra("authors", ArrayList(bookAuthors))
            intent.putIntegerArrayListExtra("ratings", ArrayList(bookRatings))
            intent.putStringArrayListExtra("comments", ArrayList(bookComments))

            startActivity(intent)
        } catch (e: Exception) {
            // Error handling: Navigation error
            showError("An error occurred while navigating: ${e.message}")
        }
    }

    /**
     * Exits the application with confirmation
     */
    private fun exitApp() {
        try {
            AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes") { _, _ ->
                    finish()
                }
                .setNegativeButton("No", null)
                .show()
        } catch (e: Exception) {
            // Error handling: Exit error
            showError("An error occurred: ${e.message}")
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