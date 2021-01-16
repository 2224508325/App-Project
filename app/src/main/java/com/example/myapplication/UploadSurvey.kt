package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import com.example.myapplication.R
import org.w3c.dom.Text

class UploadSurvey : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_survey)

        option = findViewById(R.id.spinner) as Spinner
        result = findViewById(R.id.result) as TextView

        val options = arrayOf("Head", "Upper Body", "Abdemon","Pelvic", "Limbs")
        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)


        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = options.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please Select an Option"
            }

        }



    }
}