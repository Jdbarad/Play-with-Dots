package com.builditcreative.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var T = object : TimerTask() {
            override fun run() {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
                finish()

            }
        }
        val timer = Timer()
        timer.schedule(T, 3000)

    }
}