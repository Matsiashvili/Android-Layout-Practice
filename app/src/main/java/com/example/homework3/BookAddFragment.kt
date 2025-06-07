package com.example.homework3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.homework3.SQl.BookContact.Book
import com.example.homework3.SQl.SQLDatabaseHelper

class BookAddFragment : Fragment() {

    private lateinit var titleEditText: EditText
    private lateinit var authorEditText: EditText
    private lateinit var yearEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var addButton: Button
    private lateinit var dbHelper: SQLDatabaseHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_addbook, container, false)

        titleEditText = view.findViewById(R.id.titleEditText)
        authorEditText = view.findViewById(R.id.authorEditText)
        yearEditText = view.findViewById(R.id.yearEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        addButton = view.findViewById(R.id.addButton)

        dbHelper = SQLDatabaseHelper(requireContext())

        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val author = authorEditText.text.toString()
            val year = yearEditText.text.toString().toIntOrNull() ?: 0
            val description = descriptionEditText.text.toString()

            val book = Book(0, title, author, year, description)
            dbHelper.insertBook(book)


            parentFragmentManager.popBackStack()
        }

        return view
    }
}
