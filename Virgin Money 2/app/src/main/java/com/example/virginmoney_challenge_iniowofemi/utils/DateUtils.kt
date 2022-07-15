package com.example.virginmoney_challenge_iniowofemi.utils

import java.text.SimpleDateFormat

object DateUtils {

    private val sdf = SimpleDateFormat("HH:mm:ss")
    private val sdf2 = SimpleDateFormat("dd/MM/yyyy")

    // sdf = Ex: Thu, Jun 9, '22
    fun stringToDate(string: String?): String{
        return sdf2.format(string)
    }
}