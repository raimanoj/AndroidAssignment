package com.example.testapp.data.repository

import com.example.testapp.data.local.db.DatabaseService
import com.example.testapp.data.model.Repositories
import com.example.testapp.data.remote.NetworkService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    suspend fun getRepos() = networkService.repositoriesCall()

    suspend fun insertAllRepo(list: List<Repositories>) {
        databaseService.repoDao().insertAllRepos(list)
    }

    suspend fun getAllReposLocal() = databaseService.repoDao().getAllRepos()
}