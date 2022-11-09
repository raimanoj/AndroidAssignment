package com.example.testapp.data.local.db.dao

import androidx.room.*
import com.example.testapp.data.model.Repositories

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRepos(users: List<Repositories>)


    @Query("select * from repositories")
    fun getAllRepos(): List<Repositories>
}