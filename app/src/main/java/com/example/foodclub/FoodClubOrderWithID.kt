package com.example.foodclub

data class FoodClubOrderWithID(
    val amount:String,
    val dish:String,
    val paid:String,
    val recieved:String,
    val status:String,
    val upi:String,
    val username:String,
    val id:String
)