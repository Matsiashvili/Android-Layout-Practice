package com.example.homework3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var yearTextView: TextView
    private lateinit var descriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)


        titleTextView = findViewById(R.id.titleTextView)
        authorTextView = findViewById(R.id.authorTextView)
        yearTextView = findViewById(R.id.yearTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)


        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val year = intent.getIntExtra("year", 0)
        val description = intent.getStringExtra("description")


        titleTextView.text = title
        authorTextView.text = author
        yearTextView.text = year.toString()
        descriptionTextView.text = description
    }
}
