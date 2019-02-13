package com.example.core.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.database.model.Content
import com.example.core.result.Resource
import io.reactivex.Completable

@Dao
interface ContentDao {

    @Query("SELECT * FROM content")
    fun getAll(): LiveData<List<Content>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAll(list : List<Content>) : Completable

}