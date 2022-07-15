package com.example.virginmoney_challenge_iniowofemi.utils

import com.example.virginmoney_challenge_iniowofemi.model.people.PeopleResponse
import com.example.virginmoney_challenge_iniowofemi.model.rooms.RoomsResponse

sealed class UIState{

    object LOADING: UIState()
    data class SUCCESS(val response: RoomsResponse): UIState()
    data class SUCCESS2(val response: PeopleResponse): UIState()
    data class ERROR (val error: Exception): UIState()

}