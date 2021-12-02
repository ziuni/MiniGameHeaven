package com.example.minigameheaven

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val halligaliGame = findViewById<Button>(R.id.halligali_game)
        val airhockeyGame = findViewById<Button>(R.id.airhockey_game)
        var intent:Intent? = null

        halligaliGame.setOnClickListener {
            intent = Intent(applicationContext, HalligalliMain::class.java)
            startActivity(intent)
        }
        airhockeyGame.setOnClickListener {
            intent = Intent(applicationContext, AirHockeyGame::class.java)
            startActivity(intent)
        }


    }
}
