package com.example.myapplication.Survey

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.retrieveActivity2
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_head_pain_types.*
import org.w3c.dom.Text


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