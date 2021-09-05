package com.example.agiledo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.agiledo.R

class SplashScreenActivity : AppCompatActivity() {
    lateinit var handle: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        handle=Handler(Looper.getMainLooper())
        handle.postDelayed({
            var intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}