package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search_eric.view.*
import kotlinx.android.synthetic.main.search_single_item.view.*

class searchListAdapterEric(var searchList: List<searchModel>): RecyclerView.Adapter<searchListAdapterEric.SearchListViewHolder>() {
    class SearchListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(searchModel: searchModel){
            itemView.single_item_title.text = searchModel.Product_Name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): searchListAdapterEric.SearchListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_single_item,parent, false)
        return SearchListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(
        holder: searchListAdapterEric.SearchListViewHolder,
        position: Int
    ) {
        holder.bind(searchList[position])
    }
}