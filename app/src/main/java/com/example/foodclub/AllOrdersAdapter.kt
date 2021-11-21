package com.example.foodclub

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AllOrdersAdapter(
    var context: Context,
    val listofOrders:ArrayList<FoodClubOrderWithID>
): RecyclerView.Adapter<AllOrdersAdapter.vh>() {

    inner class vh(itemview: View): RecyclerView.ViewHolder(itemview){


        var tvUsername = itemview.findViewById<TextView>(R.id.username)
        var tvDish = itemview.findViewById<TextView>(R.id.dish)
        var tvamount = itemview.findViewById<TextView>(R.id.amount)
        var tvupi = itemview.findViewById<TextView>(R.id.upi)
        var tvstatus = itemview.findViewById<TextView>(R.id.status)
        var tvrecieved = itemview.findViewById<TextView>(R.id.received)
        var tvpaid = itemview.findViewById<TextView>(R.id.paid)
        var firebaseid = itemview.findViewById<TextView>(R.id.firebaseid)

        fun setdata(order:FoodClubOrderWithID){

            tvUsername.text = order.username
            tvDish.text = order.dish
            tvamount.text = order.amount
            tvupi.text = order.upi
            tvstatus.text = order.status
            tvrecieved.text = order.recieved
            tvpaid.text = order.paid
            firebaseid.text = order.id

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        var view:View = LayoutInflater.from(context).inflate(R.layout.public_orders_item_layout,parent,false)
        var vh:vh = vh(view)
        return vh

    }

    override fun onBindViewHolder(holder: vh, position: Int) {
        val order = listofOrders[position]

        holder.setdata(order)

        holder.itemView.setOnClickListener{

            val i = Intent(context,EditOrder::class.java)
            i.putExtra("id",order.id)
            i.putExtra("amount",order.amount)
            i.putExtra("dish",order.dish)
            i.putExtra("paid",order.paid)
            i.putExtra("recieved",order.recieved)
            i.putExtra("status",order.status)
            i.putExtra("upi",order.upi)
            i.putExtra("username",order.username)
            context.startActivity(i)

        }


    }

    override fun getItemCount(): Int {
        return listofOrders.size
    }


}