package com.builditcreative.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.builditcreative.myapplication2.databinding.ActivityDotBinding
import com.builditcreative.myapplication2.databinding.ActivityHomeBinding

class DotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDotBinding
    private lateinit var dotAdapter: DotAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var number = intent.extras?.get("number")

        dotAdapter = DotAdapter()
        dotAdapter.setDotData(number as Int)

        binding.dotRecycler.layoutManager = GridLayoutManager(this,4)
        binding.dotRecycler.apply { adapter = dotAdapter }

        dotAdapter.setOnMealClickListener(object : DotAdapter.SetOnDotClickListener{
            override fun setDotClickListener(dot: Dot,postion:Int) {
                if (dot.statu=="BLUE") {
                    var dot= Dot()
                    dot.statu = "RED"
                    dotAdapter.changeState(dot,postion)
                }
            }

        })

    }
}