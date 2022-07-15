package com.example.virginmoney_challenge_iniowofemi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney_challenge_iniowofemi.MainActivity
import com.example.virginmoney_challenge_iniowofemi.R
import com.example.virginmoney_challenge_iniowofemi.adapter.PeopleAdapter
import com.example.virginmoney_challenge_iniowofemi.databinding.FragmentPeopleBinding
import com.example.virginmoney_challenge_iniowofemi.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : BaseFragment() {

    private val binding by lazy{
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    private val peopleAdapter by lazy{
        PeopleAdapter()
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
        binding.peopleRec.apply {
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = peopleAdapter
        }
    }

    private fun observeData(){
        virginMoneyViewModel.people.observe(viewLifecycleOwner) { state ->

            when (state) {
                is UIState.LOADING -> {
                }

                is UIState.SUCCESS2 -> {
                    peopleAdapter.setPeople(state.response)
                }

                is UIState.ERROR -> {
                    showError(state.error.localizedMessage){
                        virginMoneyViewModel.getPeople()
                    }
                }

                else -> {}
            }


        }

        virginMoneyViewModel.getPeople()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding.let{
            null
        }
    }
}