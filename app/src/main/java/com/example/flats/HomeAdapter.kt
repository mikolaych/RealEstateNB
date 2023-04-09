package com.example.flats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.flats.databinding.HomeItemBinding

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private val homeList = ArrayList<HomeModel>()


    class HomeHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = HomeItemBinding.bind(item)
        fun bind(home:HomeModel) = with(binding) {
            image.setImageResource(home.imageId)
            tittle.text = home.tittle

        }
        fun delete(){

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return HomeHolder(view)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.bind(homeList[position])
    }

    override fun getItemCount(): Int {
       return homeList.size
    }

    fun addHome(home:HomeModel) {
        homeList.add(home)
        notifyDataSetChanged()
    }
}