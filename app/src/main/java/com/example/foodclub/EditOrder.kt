package com.example.foodclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EditOrder : AppCompatActivity() {

    lateinit var idxx:TextView
    lateinit var amountxx:TextView
    lateinit var dishxx:TextView
    lateinit var paidxx:TextView
    lateinit var receivedxx:TextView
    lateinit var statusxx:TextView
    lateinit var upixx:TextView
    lateinit var usernamexx:TextView
    lateinit var paytouser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_order)

        idxx = findViewById(R.id.idxx)
        amountxx = findViewById(R.id.amountxx)
        dishxx = findViewById(R.id.dishxx)
        paidxx = findViewById(R.id.paidxx)
        receivedxx = findViewById(R.id.receivedxx)
        statusxx = findViewById(R.id.statusxx)
        upixx = findViewById(R.id.upixx)
        usernamexx = findViewById(R.id.usernamexx)
        paytouser = findViewById(R.id.paytouser)

        var id = intent.getStringExtra("id")
        var amount = intent.getStringExtra("amount")
        var dish = intent.getStringExtra("dish")
        var paid = intent.getStringExtra("paid")
        var recieved = intent.getStringExtra("recieved")
        var status = intent.getStringExtra("status")
        var upi = intent.getStringExtra("upi")
        var username = intent.getStringExtra("username")


        //button to pay.

        idxx.text = id
        amountxx.text = amount
        dishxx.text = dish
        paidxx.text = paid
        receivedxx.text = recieved
        statusxx.text = status
        upixx.text = upi
        usernamexx.text = username


        paytouser.setOnClickListener {

            var i = Intent(this,PaymentOption::class.java)
            i.putExtra("upiid",upi)

            startActivity(i)

        }

    }
}