package com.example.homework3.SQl

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.homework3.SQl.BookContact.Book
import com.example.homework3.SQl.BookContact.BookFiled
import com.example.homework3.SQl.BookContact.TABLE_NAME

class SQLDatabaseHelper(ctx: Context) : SQLiteOpenHelper(ctx, "BooksDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                ${BookFiled.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${BookFiled.TITLE} TEXT NOT NULL,
                ${BookFiled.AUTHOR} TEXT NOT NULL,
                ${BookFiled.YEAR} INTEGER,
                ${BookFiled.DESCRIPTION} TEXT
            )
        """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertBook(book: Book): Long {
        val cv = ContentValues().apply {
            put(BookFiled.TITLE, book.title)
            put(BookFiled.AUTHOR, book.author)
            put(BookFiled.YEAR, book.year)
            put(BookFiled.DESCRIPTION, book.description)
        }
        return writableDatabase.insert(TABLE_NAME, null, cv)
    }

    fun getAllBooks(): List<Book> {
        val books = mutableListOf<Book>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(BookFiled.ID))
                val title = cursor.getString(cursor.getColumnIndexOrThrow(BookFiled.TITLE))
                val author = cursor.getString(cursor.getColumnIndexOrThrow(BookFiled.AUTHOR))
                val year = cursor.getInt(cursor.getColumnIndexOrThrow(BookFiled.YEAR))
                val description = cursor.getString(cursor.getColumnIndexOrThrow(BookFiled.DESCRIPTION))
                books.add(Book(id, title, author, year, description))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return books
    }



}
