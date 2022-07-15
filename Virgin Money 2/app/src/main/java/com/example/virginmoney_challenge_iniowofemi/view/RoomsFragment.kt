package com.example.virginmoney_challenge_iniowofemi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney_challenge_iniowofemi.MainActivity
import com.example.virginmoney_challenge_iniowofemi.R
import com.example.virginmoney_challenge_iniowofemi.adapter.RoomsAdapter
import com.example.virginmoney_challenge_iniowofemi.databinding.FragmentRoomsBinding
import com.example.virginmoney_challenge_iniowofemi.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : BaseFragment() {

    private val binding by lazy{
        FragmentRoomsBinding.inflate(layoutInflater)
    }

    private val roomsAdapter by lazy{
        RoomsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initRecyclerView()
        observeData()
        return binding.root
    }

    private fun initRecyclerView(){
        //Recycler View
        binding.roomsRec.apply {
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = roomsAdapter
        }
    }

    private fun observeData(){
        virginMoneyViewModel.rooms.observe(viewLifecycleOwner) { state ->

            when (state) {

                is UIState.LOADING -> {
                }

                is UIState.SUCCESS -> {
                    roomsAdapter.setRooms(state.response)
                }

                is UIState.ERROR -> {
                    showError(state.error.localizedMessage){
                        virginMoneyViewModel.getRooms()
                    }
                }
                else -> {}
            }
        }
        virginMoneyViewModel.getRooms()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.let{
            null
        }
    }
}