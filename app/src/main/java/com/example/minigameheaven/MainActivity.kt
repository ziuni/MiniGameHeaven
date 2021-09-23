package com.example.minigameheaven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bell_button = findViewById<ImageButton>(R.id.bell_button)

        bell_button.setOnClickListener {
            Toast.makeText(this, "눌림", Toast.LENGTH_SHORT).show()
        }
    }
}