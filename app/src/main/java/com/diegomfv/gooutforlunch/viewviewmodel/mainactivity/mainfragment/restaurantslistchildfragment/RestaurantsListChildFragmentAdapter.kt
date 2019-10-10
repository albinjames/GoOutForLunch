package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.restaurantslistchildfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.data.model.domainmodel.restaurant.RestaurantModel

class RestaurantsListChildFragmentAdapter(
    val listOfRestaurants: MutableList<RestaurantModel>

) : RecyclerView.Adapter<RestaurantsListChildFragmentAdapter.RestaurantsViewHolder>() {

    var lastClickTime : Long = 0

    lateinit var onCardClicked : (position: Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_card, parent, false)
        return RestaurantsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfRestaurants.size
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.updateHolder(position)
    }

    fun resetList(newList: List<RestaurantModel>) {
        listOfRestaurants.clear()
        listOfRestaurants.addAll(newList)
        notifyDataSetChanged()
    }

    fun resetElement (newElement: RestaurantModel) {
        //notifyItemChanged() //TODO
//        listOfRestaurantsLiveData.distinct() //have a look
//        var a  = listOfRestaurantsLiveData.zipWithNext() //have a look
    }

    inner class RestaurantsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun updateHolder (position: Int) {

        }

    }

}