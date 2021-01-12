package com.example.myapplication.Survey

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.option_item.view.*
import org.w3c.dom.Text

class OptionAdapter(val context: Context,val question: Question) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

    private var options: ArrayList<String> = arrayListOf(question.option1,question.option2,question.option3,question.option4,question.option5)

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

            ischoosen.intchoosenposition = true
            question.userAnswer = options[position]
            notifyDataSetChanged()
            recordposition.resultposition = options[position]
        }


        if (question.userAnswer == options[position] && options[position] != " ") {
            Log.d("positionname",options[position])
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        }else if (options[position] == " "){
            holder.itemView.setBackgroundResource(R.drawable.emptyviewfornotselected)
        }
        else {
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)
        }

    }

    class ischoosen{
        companion object{
            var intchoosenposition : Boolean = false
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    class recordintofposition{
        companion object{
            var intposition = 0
        }
    }

    class recordposition{
        companion object{
            var resultposition = " "
        }
    }

    class recordresult{
        companion object{
            var resultarray = arrayListOf<String>()
        }
    }
}