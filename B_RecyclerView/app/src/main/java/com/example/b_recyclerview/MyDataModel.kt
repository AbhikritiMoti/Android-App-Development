package com.example.b_recyclerview

class MyDataModel(title: CharSequence, genre: String?, year: String? ) {

    private lateinit var title: String
    private lateinit var genre: String
    private lateinit var year: String

    init {
        this.title= title.toString()!!
        this.genre=genre!!
        this.year=year!!
    }

    fun getTitle(): String{
        return title

    }

    fun getGenre(): String{
        return genre
    }

    fun getYear(): String{
        return year
    }

}