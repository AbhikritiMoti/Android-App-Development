package com.example.l_roomdatabase


import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)

abstract class ContactDatabase: RoomDatabase() {
    abstract fun ContactDAO(): ContactDao
}