package com.example.myapplication.Survey

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Andy.Recyclerview
import com.example.myapplication.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.option_item.view.*
import org.w3c.dom.Text

class OptionAdapter(val context: Context,val question: Question) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

    private var options: List<String> = listOf(question.option1,question.option2,question.option3,question.option4,question.option5)

    inner class OptionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var optionView = itemView.findViewById<TextView>(R.id.quiz_option)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.option_item,parent,false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.optionView.text = options[position]
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return options.size
    }


}