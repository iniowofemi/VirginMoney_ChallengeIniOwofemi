package com.example.virginmoney_challenge_iniowofemi.api

import com.example.virginmoney_challenge_iniowofemi.model.people.PeopleResponse
import com.example.virginmoney_challenge_iniowofemi.model.rooms.RoomsResponse
import retrofit2.Response
import retrofit2.http.GET

interface VirginMoneyServiceAPI {
    @GET(PEOPLE_PATH)
    suspend fun getPeople(): Response<PeopleResponse>

    @GET(ROOMS_PATH)
    suspend fun getRooms(): Response<RoomsResponse>

    companion object{
        const val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"
        private const val PEOPLE_PATH = "people"
        private const val ROOMS_PATH = "rooms"
    }
}