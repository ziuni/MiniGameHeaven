package com.example.minigameheaven

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HalligalliMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halligali_main)

        val startBtn = findViewById<ImageButton>(R.id.start_btn)
        val ruleBtn = findViewById<ImageButton>(R.id.rule_btn)
        val endBtn = findViewById<ImageButton>(R.id.end_btn)

        startBtn.setOnClickListener{
            //게임 시작
            val intent = Intent(applicationContext, HalligalliGame::class.java)
            startActivity(intent)
        }
        ruleBtn.setOnClickListener{
            //게임 방법
//            val intent = Intent(applicationContext, s::class.java)
//            startActivity(intent)
        }
        endBtn.setOnClickListener{
            //홈화면 이동
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}