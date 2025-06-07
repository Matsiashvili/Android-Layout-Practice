package com.example.homework3.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.R
import com.example.homework3.SQl.BookContact.Book

class BookAdapter(
    private val bookList: List<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {


    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_books, parent, false)
        return BookViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentItem = bookList[position]

        holder.titleTextView.text = currentItem.title
        holder.authorTextView.text = currentItem.author

        holder.itemView.setOnClickListener {
            onItemClick(currentItem)
        }
    }


    override fun getItemCount() = bookList.size
}
