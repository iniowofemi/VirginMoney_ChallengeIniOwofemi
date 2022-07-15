package com.example.virginmoney_challenge_iniowofemi.ui.viewmodel

import com.example.virginmoney_challenge_iniowofemi.di.RepositoryModule
import com.example.virginmoney_challenge_iniowofemi.model.people.PeopleResponse
import com.example.virginmoney_challenge_iniowofemi.model.rooms.RoomsResponse
import com.example.virginmoney_challenge_iniowofemi.repository.VirginMoneyRepository
import retrofit2.Response

class VirginMoneyFakeRepo: VirginMoneyRepository {
    override suspend fun getPeople(): Response<PeopleResponse> {
        val newPeopleList = Response.success(PeopleResponse())
        return newPeopleList
    }

    override suspend fun getRooms(): Response<RoomsResponse> {
        val newRoomsList = Response.success(RoomsResponse())
        return newRoomsList
    }
}