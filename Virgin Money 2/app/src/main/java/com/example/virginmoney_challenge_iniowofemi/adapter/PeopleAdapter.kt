package com.example.virginmoney_challenge_iniowofemi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney_challenge_iniowofemi.R
import com.example.virginmoney_challenge_iniowofemi.databinding.PeopleEntryBinding
import com.example.virginmoney_challenge_iniowofemi.model.people.PeopleResponseItem
import com.squareup.picasso.Picasso

class PeopleAdapter(
    private val mPeopleList: MutableList<PeopleResponseItem> = mutableListOf()
) : RecyclerView.Adapter<MyViewHolder>(
) {

    fun setPeople(people: MutableList<PeopleResponseItem>) {
        mPeopleList.clear()
        mPeopleList.addAll(people)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder =
        MyViewHolder(
            PeopleEntryBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(mPeopleList[position])

    override fun getItemCount(): Int  = mPeopleList.size

}
class MyViewHolder (
    private val binding: PeopleEntryBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(people: PeopleResponseItem)
    {
        binding.peopleFirstName.text = people.firstName
        binding.peopleLastName.text = people.lastName
        binding.peopleJobTitle.text = people.jobtitle
        binding.peopleEmail.text = people.email
        Picasso.get()
            .load(people.avatar)
            .placeholder(R.drawable.ic_people_24dp_foreground)
            .fit()
            .into(binding.peoplePfp)
    }
}