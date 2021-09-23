package com.example.minigameheaven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        var screenWidth = getWindowManager().getDefaultDisplay()

        var bell_button = findViewById<ImageButton>(R.id.bell_button)

        bell_button.setOnClickListener {
            Toast.makeText(this, "눌림", Toast.LENGTH_SHORT).show()
        }
    }
}