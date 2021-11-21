package com.example.foodclub

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.firebase.firestore.FirebaseFirestore

class SignUp : AppCompatActivity() {

    lateinit var etpassword:EditText
    lateinit var etusername:EditText
    lateinit var signupbutton:MaterialButton

    var colref = FirebaseFirestore.getInstance().collection("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var sharedprefs = this.getSharedPreferences("authhelper",Context.MODE_PRIVATE)
        var editor = sharedprefs.edit()

        signupbutton = findViewById(R.id.signupgo)
        etpassword = findViewById(R.id.etpassword)
        etusername = findViewById(R.id.etusername)

        signupbutton.setOnClickListener {

            var user = etusername.text.toString()
            var pass = etpassword.text.toString()
            var credit = "0"

            editor.putString("username",user).apply()

            var userobj = UserObject(user,pass,credit)

            colref.document(user).set(userobj)

            Toast.makeText(this,"user created",Toast.LENGTH_LONG).show()

            //val intent = Intent(this,AllOrdersActivity::class.java)
            //startActivity(intent)



        }



    }
}