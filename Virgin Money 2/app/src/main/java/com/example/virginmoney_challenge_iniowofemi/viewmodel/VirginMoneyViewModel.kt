package com.example.virginmoney_challenge_iniowofemi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoney_challenge_iniowofemi.repository.VirginMoneyRepository
import com.example.virginmoney_challenge_iniowofemi.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VirginMoneyViewModel @Inject constructor(
    private val virginMoneyRepository: VirginMoneyRepository
) : ViewModel() {

    private val _people: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val people: LiveData<UIState> get() = _people

    private val _rooms: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val rooms: LiveData<UIState> get() = _rooms

    fun getPeople() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = virginMoneyRepository.getPeople()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _people.postValue(UIState.SUCCESS2(it))
                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _people.postValue(UIState.ERROR(e))
                }
            }
            val response = virginMoneyRepository.getPeople()
        }
    }

    fun getRooms() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = virginMoneyRepository.getRooms()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _rooms.postValue(UIState.SUCCESS(it))
                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _rooms.postValue(UIState.ERROR(e))
                }
            }
            val response = virginMoneyRepository.getRooms()
        }
    }
    public override fun onCleared() {
        super.onCleared()
    }
}