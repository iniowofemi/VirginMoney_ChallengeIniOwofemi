package com.example.virginmoney_challenge_iniowofemi.di

import com.example.virginmoney_challenge_iniowofemi.repository.VirginMoneyRepository
import com.example.virginmoney_challenge_iniowofemi.repository.VirginMoneyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideVirginRepository(virginRepositoryImpl: VirginMoneyRepositoryImpl): VirginMoneyRepository

}