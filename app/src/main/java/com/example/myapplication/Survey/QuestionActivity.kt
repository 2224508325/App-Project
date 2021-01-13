package com.example.myapplication.Survey

import android.content.Intent
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.fragments.SymptomFragment
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_ingredient_popup.*
import kotlinx.android.synthetic.main.activity_main_head_pain_types.*
import kotlinx.android.synthetic.main.activity_question.*
import kotlinx.android.synthetic.main.rating.*


class QuestionActivity : AppCompatActivity() {

    var quizzes : MutableList<Quiz>? = null
    var questions:MutableMap<String,Question>? = null
    var individualquestion: MutableList<Question>? = null
    var rating: String = ""
    private var index = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        setUpFirestore()
        setUpEventListener()
        OptionAdapter.recordresult.resultarray.clear()

        Log.d("123321", OptionAdapter.Ratingornot.rating.toString())
    }
    private var inttemp = OptionAdapter.recordintofposition.intposition
    private var temp = OptionAdapter.recordresult.resultarray




    private fun setUpEventListener() {


        btnPrevious.setOnClickListener{
            inttemp --
            temp.removeAt(inttemp)
            index--
            val well = index
            bindViews()
            Log.d("FinalQuiz",temp.toString())
            Log.d("FinalQuiz", inttemp.toString())
            Log.d("FinalQuiz", well.toString())
        }

        btnNext.setOnClickListener{

                if(OptionAdapter.ischoosen.intchoosenposition || OptionAdapter.haschoosenratingornot.yesno) {
                    index++

                    if(!OptionAdapter.Ratingornot.rating) {

                        temp.add(OptionAdapter.recordposition.resultposition.toString())
                        inttemp++
                        bindViews()

                        Log.d("FinalQuiz", inttemp.toString())
                    } else {

                        temp.add(OptionAdapter.ratingvalue.ratingvalue.toString())
                        inttemp++
                        bindViews()
                        OptionAdapter.haschoosenratingornot.yesno = false
                    }

                } else{
                Toast.makeText(this,"Please make a selection", Toast.LENGTH_SHORT).show()
                }
            OptionAdapter.ischoosen.intchoosenposition = false
       }


        btnSubmit.setOnClickListener{

            if(OptionAdapter.ischoosen.intchoosenposition || OptionAdapter.haschoosenratingornot.yesno) {
                if(!OptionAdapter.Ratingornot.rating) {
                    temp.add(OptionAdapter.recordposition.resultposition.toString())
                }else{
                    temp.add(OptionAdapter.ratingvalue.ratingvalue.toString())
                }


                intent = Intent(this, IngredientPopup::class.java)
                intent.putExtra("ARRAYLIST", OptionAdapter.recordresult.resultarray.toString())
                startActivity(intent)
                OptionAdapter.recordresult.resultarray.clear()
                finish()
            }else {
                Toast.makeText(this,"Please make a selection", Toast.LENGTH_SHORT).show()
            }
            }
        }

    private fun setUpFirestore() {

        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        val pain:String? = intent.getStringExtra("PAIN")

        Log.d("last",SymptomFragment.myPainType.stuffDone)

            firestore.collection("Survey")
                .document("8OlHlFAdEH1hs0RTOV8L").collection(SymptomFragment.myPainType.stuffDone)
                    .whereEqualTo("title", pain).get().addOnSuccessListener {
                if(it != null && !it.isEmpty){
                    quizzes = it.toObjects(Quiz::class.java)
                    questions = quizzes!![0].questions
                    individualquestion = it.toObjects(Question::class.java)
                    rating = individualquestion!![0].rating

                    bindViews()
            }
        }
    }

    private fun bindViews() {


        btnPrevious.visibility = View.GONE
        btnSubmit.visibility = View.GONE
        btnNext.visibility = View.GONE

        if(questions!!.size ==1){
            btnSubmit.visibility = View.VISIBLE
        } else if(index == 1 && questions!!.size != 1){
            btnNext.visibility = View.VISIBLE
        }else if(index == questions!!.size){
            btnSubmit.visibility = View.VISIBLE
            btnPrevious.visibility = View.VISIBLE
        }else{
            btnPrevious.visibility = View.VISIBLE
            btnNext.visibility = View.VISIBLE
        }


        val question = questions!!["question$index"]
        question?.let {

            Description.text = it.description
            val optionAdapter = OptionAdapter(this, it)
            optionList.layoutManager = LinearLayoutManager(this)
            optionList.adapter = optionAdapter
            optionList.setHasFixedSize(true)
        }
    }
}