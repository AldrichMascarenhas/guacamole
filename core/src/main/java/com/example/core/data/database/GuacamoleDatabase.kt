package com.example.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.database.dao.ContentDao
import com.example.core.data.database.model.Content


@Database(
    entities = [
        Content::class
    ],
    version = 1
)
abstract class GuacamoleDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao
}