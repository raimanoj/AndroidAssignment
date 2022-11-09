package com.example.testapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.data.local.db.dao.RepoDao
import com.example.testapp.data.model.Repositories
import javax.inject.Singleton


@Singleton
@Database(
    entities = [
        Repositories::class
    ],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun repoDao(): RepoDao

}