package com.example.testapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.model.Repositories
import com.example.testapp.data.repository.MainRepository
import com.example.testapp.utils.NetWorkUtility
import com.example.testapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository,
    private val netWorkUtility: NetWorkUtility
) : ViewModel() {

    val repos = MutableLiveData<Resource<List<Repositories>>>()

    init {
        getAllRepos()
    }

    private fun getAllRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            repos.postValue(Resource.loading(null))
            if (!netWorkUtility.isNetworkAvailable()) {
                repos.postValue(Resource.success(mainRepository.getAllReposLocal()))
                return@launch
            }
            try {
                val response = mainRepository.getRepos()
                repos.postValue(Resource.success(response))
                mainRepository.insertAllRepo(response)
            } catch (e: Exception) {
                repos.postValue(Resource.error(e.toString(), null))
            }
        }
    }

}