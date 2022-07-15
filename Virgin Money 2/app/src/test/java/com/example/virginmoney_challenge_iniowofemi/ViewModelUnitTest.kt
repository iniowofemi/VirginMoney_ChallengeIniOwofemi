package com.example.virginmoney_challenge_iniowofemi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.virginmoney_challenge_iniowofemi.ui.viewmodel.VirginMoneyFakeRepo
import com.example.virginmoney_challenge_iniowofemi.utils.UIState
import com.example.virginmoney_challenge_iniowofemi.viewmodel.VirginMoneyViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class ViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var tempRepository: VirginMoneyFakeRepo
    private lateinit var tempViewModel: VirginMoneyViewModel

    @Before
    fun setUp() {
        tempRepository = VirginMoneyFakeRepo()
        tempViewModel = VirginMoneyViewModel(tempRepository)
    }

    @Test
    fun hasPeopleList() {
        var expectedState = UIState.LOADING
        tempViewModel.people.observeForever{
            assertThat(it).isNotNull()
            assertThat(it).isEqualTo(expectedState)
        }
        tempViewModel.getPeople()
    }

    @Test
    fun hasRoomsList() {
        var expectedState = UIState.LOADING
        tempViewModel.rooms.observeForever{
            assertThat(it).isNotNull()
            assertThat(it).isEqualTo(expectedState)
        }
        tempViewModel.getRooms()
    }
}