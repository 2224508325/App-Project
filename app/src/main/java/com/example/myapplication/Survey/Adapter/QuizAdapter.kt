package com.example.myapplication.Survey.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Survey.Class.QuestionActivity
import com.example.myapplication.Survey.Model.Quiz


class QuizAdapter(val context: Context,val Qlist: List<Quiz>) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_item_type_menu,parent,false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {

        if(OptionAdapter.Ratingornot.rating == false ) {
            holder.textViewTitle.text = Qlist[position].title

            holder.itemView.setOnClickListener {
                val intent = Intent(context, QuestionActivity::class.java)
                intent.putExtra("PAIN", Qlist[position].title)
                context.startActivity(intent)
            }
        }else{

            holder.textintro.text = Qlist[position].title
            holder.itemView.setOnClickListener {
                val intent = Intent(context, QuestionActivity::class.java)
                intent.putExtra("PAIN", Qlist[position].title)
                context.startActivity(intent)
            }

        }

    }

    override fun getItemCount(): Int {
        return Qlist.size
    }
    inner class QuizViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var textViewTitle:TextView = itemView.findViewById(R.id.quizTitle)
        var cardContainer:CardView = itemView.findViewById(R.id.cardContainer)
        val textintro = itemView.findViewById<TextView>(R.id.introtext)


    }
}