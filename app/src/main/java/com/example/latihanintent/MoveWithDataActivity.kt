package com.example.latihanintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvdatamasuk: TextView = findViewById(R.id.TV_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE,0)

        val text = "Name : $name, Your Age : $age"
        tvdatamasuk.text = text


    }
}