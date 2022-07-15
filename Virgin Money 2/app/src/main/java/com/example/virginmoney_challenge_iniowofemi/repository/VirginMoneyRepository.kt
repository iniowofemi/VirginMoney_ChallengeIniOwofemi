package com.example.virginmoney_challenge_iniowofemi.repository

import com.example.virginmoney_challenge_iniowofemi.api.VirginMoneyServiceAPI
import com.example.virginmoney_challenge_iniowofemi.model.people.PeopleResponse
import com.example.virginmoney_challenge_iniowofemi.model.rooms.RoomsResponse
import retrofit2.Response
import javax.inject.Inject

interface VirginMoneyRepository {
    suspend fun getPeople(): Response<PeopleResponse>
    suspend fun getRooms(): Response<RoomsResponse>
}

class VirginMoneyRepositoryImpl @Inject constructor (
    private val virginMoneyServiceApi: VirginMoneyServiceAPI
) : VirginMoneyRepository{

    override suspend fun getPeople(): Response<PeopleResponse> {
        return virginMoneyServiceApi.getPeople()
    }

    override suspend fun getRooms(): Response<RoomsResponse> {
        return virginMoneyServiceApi.getRooms()
    }
}