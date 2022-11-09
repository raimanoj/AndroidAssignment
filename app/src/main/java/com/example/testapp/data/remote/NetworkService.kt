package com.example.testapp.data.remote

import com.example.testapp.data.model.Repositories
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.REPOSITORIES)
    suspend fun repositoriesCall(): List<Repositories>

}