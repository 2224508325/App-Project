package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlinx.android.synthetic.main.fragment_doctor.*
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter (private var givenData:ArrayList<ProductTempleteinRecyclerView>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_row,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productlsit = givenData[position]
        holder.bind(productlsit)
    }
    override fun getItemCount(): Int {
        return givenData.size

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // ProductNameID variable is for the ID of the product to be used as further information is retrived
        val ProductNameID : TextView = itemView.findViewById(R.id.ProductNameInRecyclerView)

        init{
            itemView.setOnClickListener{
            val intent= Intent(itemView.context, retrieveActivity2::class.java)
                itemView.context.startActivity(intent)

                val snack: String = "Item position Clicked: $adapterPosition"
                Snackbar.make(itemView,snack,Snackbar.LENGTH_SHORT).show()
            }
        }

        fun bind(List: ProductTempleteinRecyclerView){
            itemView.ProductNameInRecyclerView.text = List.ProductNameInRecyclerView
        }

    }


}