package com.example.myapplication
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class retrieveProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        readProduct()
    }

    fun readProduct(){
        val db = FirebaseFirestore.getInstance()
        db.collection("product_sample")
                .get()
                .addOnCompleteListener{
                    val result: StringBuffer = StringBuffer()

                    if(it.isSuccessful){
                        for(document in it.result!!){
                            result.append(document.data.getValue("Bar_Code_Number")).append(" ")
                            result.append(document.data.getValue("Package")).append(" ")
                            result.append(document.id).append("\n\n")
                            //document.id
                            //result.append(document.data.getValue("brand_name")).append("\n\n")

                        }


                        var textViewResult : TextView
                        textViewResult = findViewById(R.id.productView)
                        textViewResult.setText(result)

                    }

                }

    }
}

