package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore


class retrieveActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reult_activity)

        readFireStoreData()
    }

    fun readFireStoreData(){
        val db = FirebaseFirestore.getInstance()
        db.collection("sample_id")
                .get()
                .addOnCompleteListener{
                    val result: StringBuffer = StringBuffer()

                    if(it.isSuccessful){
                        for(document in it.result!!){
                            result.append(document.data.getValue("ID")).append(" ")
                            result.append(document.data.getValue("Manufactor")).append(" ")
                            result.append(document.data.getValue("Name")).append("\n\n")

                        }
                        var textViewResult : TextView
                        textViewResult = findViewById(R.id.textViewResult)
                        textViewResult.setText(result)

                    }

                }

    }
}

