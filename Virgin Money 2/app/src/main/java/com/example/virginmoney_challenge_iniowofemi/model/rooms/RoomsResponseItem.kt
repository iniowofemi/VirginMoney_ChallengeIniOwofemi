package com.example.virginmoney_challenge_iniowofemi.model.rooms


import com.google.gson.annotations.SerializedName

data class RoomsResponseItem(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isOccupied")
    val isOccupied: Boolean?,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int?
)