package com.example.myapplication.Survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_ingredient_popup.*

class IngredientPopup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_popup)


        var BodyPart:String? = intent.getStringExtra("ARRAYLIST")
        SurveyIngredientResult.text = BodyPart.toString()

    }
}