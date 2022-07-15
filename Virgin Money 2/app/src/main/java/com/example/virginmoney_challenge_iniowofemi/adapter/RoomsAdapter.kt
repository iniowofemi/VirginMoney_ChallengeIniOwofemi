package com.example.virginmoney_challenge_iniowofemi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney_challenge_iniowofemi.databinding.RoomsEntryBinding
import com.example.virginmoney_challenge_iniowofemi.model.rooms.RoomsResponseItem

class RoomsAdapter(
    private val mRoomsList: MutableList<RoomsResponseItem> = mutableListOf()
) : RecyclerView.Adapter<MyViewHolder2>() {

    fun setRooms(rooms: MutableList<RoomsResponseItem>) {
        mRoomsList.clear()
        mRoomsList.addAll(rooms)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder2 =
        MyViewHolder2(
            RoomsEntryBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) =
        holder.bind(mRoomsList[position])

    override fun getItemCount(): Int  = mRoomsList.size

}
class MyViewHolder2 (
    private val binding: RoomsEntryBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(room: RoomsResponseItem)
    {
        binding.roomId.text = room.id
        if(room.isOccupied == true){
            binding.roomOccupied.text = "Occupied"
        } else binding.roomOccupied.text = "Open"
        binding.roomMax.text = room.maxOccupancy.toString()
        binding.roomCreated.text = room.createdAt
    }
}

//class RoomAdapter(
//    private val mRoomsList: MutableList<RoomsResponseItem> = mutableListOf()
//) : RecyclerView.Adapter<MyViewHolder>(
//) {
//
//    fun setRooms(rooms: MutableList<RoomsResponseItem>) {
//        mRoomsList.clear()
//        mRoomsList.addAll(rooms)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder =
//        MyViewHolder(
//            RoomRowViewBinding.inflate(
//                LayoutInflater.from(parent.context ),
//                parent,
//                false
//            )
//        )
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
//        holder.bind(mRoomsList[position])
//
//    override fun getItemCount(): Int  = mRoomsList.size
//
//}
//
//class MyViewHolder (
//    private val binding: RoomRowViewBinding
//) : RecyclerView.ViewHolder(binding.root){
//
//    fun bind(room: RoomsResponseItem)
//    {
//        binding.roomIdTxtVw.text = room.id
//        if(room.isOccupied == true){
//            binding.roomOccupiedTxtVw.text = "Occupied"
//        } else binding.roomOccupiedTxtVw.text = "Open"
//        binding.roomMaxTxtVw.text = room.maxOccupancy.toString()
//        binding.roomCreatedTxtVw.text = room.createdAt
//    }
//}