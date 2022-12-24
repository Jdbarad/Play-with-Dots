package com.builditcreative.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.builditcreative.myapplication2.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    val NUMBER = "number"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener {
            if (binding.numberText.text?.isEmpty() == true) {
                Snackbar.make(binding.root,"Enter Any Number",Snackbar.LENGTH_LONG).show()
            } else {
                var intent = Intent(this,DotActivity::class.java)
                intent.putExtra(NUMBER,binding.numberText.text.toString().toIntOrNull())
                startActivity(intent)
            }
        }

    }
}