package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore


class EricActivity: AppCompatActivity() {

    lateinit var ID: EditText
    lateinit var Manufactor: EditText
    lateinit var Name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eric)

        // Eric: for firestore save data
        val save_button: Button = findViewById(R.id.Save)
        save_button.setOnClickListener {
            ID = findViewById(R.id.InputID)
            Manufactor = findViewById(R.id.InputManufactor)
            Name = findViewById(R.id.InputName)
            saveFireStore()
        }

        //
    }
    fun saveFireStore(){
        val id = ID.text.toString()
        val manufactor = Manufactor.text.toString().trim()
        val name = Name.text.toString().trim()

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String,Any> = HashMap()
        user["ID"] = id
        user["Manufactor"] = manufactor
        user["Name"] = name
        db.collection("sample_id")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this@EricActivity,"record added successfully", Toast.LENGTH_SHORT).show()
            }
    }
}