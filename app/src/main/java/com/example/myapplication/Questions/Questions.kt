package com.example.myapplication.Questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Andy.RecyclerAdapter
import com.example.myapplication.Andy.Recyclerview
import com.example.myapplication.R
import com.example.myapplication.searchModel
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.database.*
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirestoreRegistrar
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_questions.*
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlinx.android.synthetic.main.activity_recyclerview.view.*
import kotlinx.android.synthetic.main.activity_search_eric.*
import kotlinx.android.synthetic.main.reult_activity.*
import kotlinx.android.synthetic.main.reult_activity.view.*
import org.w3c.dom.Text

data class options(
    val option: String = " "
)
class optionsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

class Questions : AppCompatActivity() {

    private var arrayList = ArrayList<Model>()

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


        val myAdapter = QuestionAdapter(arrayList)
        recyclerViewOptions.hasFixedSize()
        recyclerViewOptions.layoutManager = LinearLayoutManager(this)
        recyclerViewOptions.adapter = myAdapter

        //readQuestionsFromFireStore()


        //last test
        val query =db.collection("Questions")
        val options = FirestoreRecyclerOptions.Builder<options>().setQuery(query,options::class.java).setLifecycleOwner(this).build()

        val adapter = object : FirestoreRecyclerAdapter<options, optionsViewHolder>(options){

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): optionsViewHolder {
                val view =LayoutInflater.from(this@Questions).inflate(R.layout.questions_row,parent,false)
                return optionsViewHolder(view)
            }

            override fun onBindViewHolder(holder: optionsViewHolder, position: Int, model: options) {
                val singleoption : TextView = holder.itemView.findViewById(R.id.answerSpace)
                singleoption.text = model.option
            }
        }

        recyclerViewOptions.adapter = adapter
        recyclerViewOptions.layoutManager = LinearLayoutManager(this)

    }

    fun readQuestionsFromFireStore(){
        val questionsdb = FirebaseFirestore.getInstance()
        questionsdb.collection("Questions").get().addOnCompleteListener{
            val result :StringBuffer = StringBuffer()
            if (it.isSuccessful){
                for(document in it.result!!){
                    result.append(document.data.getValue("question"))
                }
                var questions: TextView
                questions = findViewById(R.id.questionsText)
                questions.setText(result)

            }
        }
    }




}


