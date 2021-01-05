package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.Arrays


class retrieveActivity2 : AppCompatActivity() {
    private val testList: ProductList = ProductList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reult_activity)
        //var testList : ProductList
        val message : String? = getIntent().getStringExtra("ProductNameID")

        //readFireStoreData()
        findProductByName("herb test medicine")
        if (message != null) {
            findProductByName(message)
        }
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

    //use for arraysearch
    fun append(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }
    //use for array search
    fun productArray():Array<String>{
        var names:Array<String> = emptyArray()

        val db = FirebaseFirestore.getInstance()
        db.collection("Product")
                .get()
                .addOnCompleteListener{
                    val result: StringBuffer = StringBuffer()

                    if(it.isSuccessful){
                        for(document in it.result!!){
                            result.append(document.data.getValue("Product_Name"))
                            names = append(names, result.toString())

                        }
                    }

                }
        return names
    }
    // use for product page
    fun findProductByName(name: String){
        val db = FirebaseFirestore.getInstance()
        db.collection("Product").whereEqualTo("Product_Name",name)
                .get()
                .addOnCompleteListener{
                    val prName: StringBuffer = StringBuffer()
                    val bcNum: StringBuffer = StringBuffer()
                    val pac: StringBuffer = StringBuffer()
                    val brand: StringBuffer = StringBuffer()
                    val manfac: StringBuffer = StringBuffer()
                    val mIngre: StringBuffer = StringBuffer()
                    val aIngre: StringBuffer = StringBuffer()
                    val desc: StringBuffer = StringBuffer()
                    val ind: StringBuffer = StringBuffer()
                    val SA: StringBuffer = StringBuffer()


                    if(it.isSuccessful){
                        for(document in it.result!!){
                            prName.append(document.data.getValue("Product_Name"))
                            bcNum.append(document.data.getValue("Bar_Code_Number"))
                            pac.append(document.data.getValue("Package"))
                            brand.append(document.data.getValue("Brand"))
                            manfac.append(document.data.getValue("Manufacture"))
                            mIngre.append(document.data.getValue("Main_Ingredient"))
                            aIngre.append(document.data.getValue("All_Ingredient"))
                            desc.append(document.data.getValue("Description"))
                            ind.append(document.data.getValue("Indication"))
                            SA.append(document.data.getValue("Side_Affect"))
                            // Reference to an image file in Cloud Storage
                            //val storageReference = FirebaseStorage.getInstance()

                            // ImageView in your Activity
                            val imageView = findViewById<ImageView>(R.id.testImage)

                            // Download directly from StorageReference using Glide
                            // (See MyAppGlideModule for Loader registration)
                            Glide.with(this /* context */)
                                    .load(document.data.getValue("Product_Picture"))
                                    .into(imageView)


                        }
                        var textViewprName : TextView
                        textViewprName = findViewById(R.id.testName)
                        textViewprName.setText(prName)

                        var textViewbcNum : TextView
                        textViewbcNum = findViewById(R.id.testBarCodeNum)
                        textViewbcNum.setText(bcNum)

                        var textViewpac : TextView
                        textViewpac = findViewById(R.id.testPackage)
                        textViewpac.setText(pac)

                        var textViewbrand : TextView
                        textViewbrand = findViewById(R.id.testBrand)
                        textViewbrand.setText(brand)

                        var textViewmanfac : TextView
                        textViewmanfac = findViewById(R.id.testManufacture)
                        textViewmanfac.setText(manfac)

                        var textViewmIngre : TextView
                        textViewmIngre = findViewById(R.id.testMainIngredient)
                        textViewmIngre.setText(mIngre)

                        var textViewaIngre : TextView
                        textViewaIngre = findViewById(R.id.testAllIngredient)
                        textViewaIngre.setText(aIngre)

                        var textViewdesc : TextView
                        textViewdesc = findViewById(R.id.testDescription)
                        textViewdesc.setText(desc)

                        var textViewind : TextView
                        textViewind = findViewById(R.id.testIndication)
                        textViewind.setText(ind)

                        var textViewSA : TextView
                        textViewSA = findViewById(R.id.testSideAffect)
                        textViewSA.setText(SA)

                    }

                }
    }
}

