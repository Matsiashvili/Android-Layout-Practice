package com.example.homework3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.RecyclerView.BookAdapter
import com.example.homework3.SQl.SQLDatabaseHelper

class BookListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var dbHelper: SQLDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_booklist, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        dbHelper = SQLDatabaseHelper(requireContext())
        val bookList = dbHelper.getAllBooks()

        bookAdapter = BookAdapter(bookList) { book ->

            val intent = Intent(context, BookDetailsActivity::class.java)
            intent.putExtra("title", book.title)
            intent.putExtra("author", book.author)
            intent.putExtra("year", book.year)
            intent.putExtra("description", book.description)
            context?.startActivity(intent)
        }

        recyclerView.adapter = bookAdapter

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}
