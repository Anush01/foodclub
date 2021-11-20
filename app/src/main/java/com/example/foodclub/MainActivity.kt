package com.example.foodclub

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoadLocale()
        setContentView(R.layout.activity_main)

        //edit
        //edit2
        btn = findViewById(R.id.BtnChange)

        val actionBar = supportActionBar
        actionBar?.title = resources.getString(R.string.app_name)
        btn.setOnClickListener {
            showLanguage()
        }
    }

    private fun showLanguage() {
        val listLanguage = arrayOf("हिंदी" , "English")

        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose language")
        mBuilder.setSingleChoiceItems(listLanguage, -1) { dialog , which ->
            if (which == 0){
                setlocate("hin")
                recreate()
            }else if (which == 1){
                setlocate("eng")
                recreate()
            }

            dialog.dismiss()
        }
        val mdialog = mBuilder.create()
        mdialog.show()
    }

    private fun setlocate(lang : String){
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val  config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Setting", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang" , lang)
        editor.apply()


    }

    private fun LoadLocale(){
        val sharedPreferences = getSharedPreferences("Setting",Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang" , "")
        if (language != null) {
            setlocate(language)
        }
    }
}