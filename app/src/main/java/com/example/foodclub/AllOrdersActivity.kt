package com.example.foodclub

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlin.math.sign

class AllOrdersActivity : AppCompatActivity() {

    var colref = FirebaseFirestore.getInstance().collection("Users")
    var publicorders = FirebaseFirestore.getInstance().collection("foodcluborders")
    lateinit var signupbutton:MaterialButton
    lateinit var loginbutton:MaterialButton
    lateinit var allpublicorders:RecyclerView
    var listoforders:ArrayList<FoodClubOrderWithID> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_orders)
        loginbutton = findViewById(R.id.loginbutton)
        signupbutton = findViewById(R.id.signupbutton)
        allpublicorders = findViewById(R.id.allpublicorders)

        val sharedpref = this.getSharedPreferences("authhelper",Context.MODE_PRIVATE)

        var username:String = sharedpref.getString("username","1").toString()

        Log.d("xkcd",username)

        if(username != "1"){

            signupbutton.visibility = View.GONE
            loginbutton.visibility = View.GONE
           // allpublicorders.visibility = View.GONE

            publicorders.whereEqualTo("status","Unfilled").get().addOnSuccessListener {

                for (doc in it) {

                    val amount = doc.data["amount"] as String
                    val dish = doc.data["dish"] as String
                    val paid = doc.data["paid"] as String
                    val recieved = doc.data["recieved"] as String
                    val status = doc.data["status"] as String
                    val upi = doc.data["upi"] as String
                    val username = doc.data["username"] as String

                    val id = doc.id

                    val foodcluborder =
                        FoodClubOrderWithID(amount, dish, paid, recieved, status, upi, username, id)

                    listoforders.add(foodcluborder)

                }

                val adapter = AllOrdersAdapter(this, listoforders)
                val llm = LinearLayoutManager(this)
                allpublicorders.adapter = adapter
                allpublicorders.layoutManager = llm

            }

            Toast.makeText(this,username,Toast.LENGTH_LONG).show()

        }else{

            //hide the rv.
            allpublicorders.visibility = View.GONE





        }

        signupbutton.setOnClickListener {

            var intent = Intent(this,SignUp::class.java)
            startActivity(intent)

        }






    }
}