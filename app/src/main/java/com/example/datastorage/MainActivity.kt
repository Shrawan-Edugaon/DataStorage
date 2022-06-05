package com.example.datastorage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var name : TextView
    lateinit var  email : TextView
    lateinit var sharedPreferences:SharedPreferences

    val myPreferences = "mypref"
    val nameKey = "NameKey"
    val emailKey = "EmailKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.nameEdt)

        email = findViewById(R.id.emailEdt)

        sharedPreferences = getSharedPreferences(myPreferences,Context.MODE_PRIVATE)
        if (sharedPreferences.contains(nameKey))
        {
            name.text = sharedPreferences.getString(nameKey,"")
        }
        if (sharedPreferences.contains(emailKey))
        {
            email.text = sharedPreferences.getString(emailKey,"")
        }
    }
    fun saveData(view: View)
    {
        val nameStr = name.text.toString()
        val emailStr = email.text.toString()

        val editor = sharedPreferences.edit()

        editor.putString(nameKey,nameStr)
        editor.putString(emailKey,emailStr)

        editor.commit()

        Toast.makeText(applicationContext,"Data Saved...",Toast.LENGTH_SHORT).show()
    }
    fun clearData(view: View){
        name.text = ""
        email.text = ""

        Toast.makeText(applicationContext,"Data Cleared...",Toast.LENGTH_SHORT).show()

    }

    fun readData(view: View)
    {
        sharedPreferences = getSharedPreferences(myPreferences,Context.MODE_PRIVATE)
        if (sharedPreferences.contains(nameKey))
        {
            name.text = sharedPreferences.getString(nameKey,"")
        }
        if (sharedPreferences.contains(emailKey))
        {
            email.text = sharedPreferences.getString(emailKey,"")
        }
        Toast.makeText(applicationContext,"Data Retrieved...",Toast.LENGTH_SHORT).show()

    }
}