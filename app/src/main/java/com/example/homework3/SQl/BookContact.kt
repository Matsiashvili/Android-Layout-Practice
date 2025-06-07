package com.example.homework3.SQl

object BookContact {
    const val TABLE_NAME  = "Books"
    data class Book( val id: Int,
                     val title: String,
                     val author: String,
                     val year: Int,
                     val description: String,
        )
    object BookFiled {
        const val ID = "ID"
        const val TITLE = "TITLE"
        const val AUTHOR = "AUTHOR"
        const val YEAR = "YEAR"
        const val DESCRIPTION = "DESCRIPTION"
    }
}