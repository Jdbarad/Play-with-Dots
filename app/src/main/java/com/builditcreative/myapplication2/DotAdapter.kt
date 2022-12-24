package com.builditcreative.myapplication2

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.builditcreative.myapplication2.databinding.RecylerDotBinding
import com.google.android.material.color.MaterialColors.getColor
import java.security.AccessController.getContext
import java.util.*
import kotlin.collections.ArrayList

class DotAdapter:RecyclerView.Adapter<DotAdapter.ViewHolder>(){

    private var listDots = ArrayList<Dot>()
    private lateinit var setDotClickListener:SetOnDotClickListener

    fun setOnMealClickListener(setOnMealClickListener: SetOnDotClickListener){
        this.setDotClickListener = setOnMealClickListener
    }

    fun setDotData(size:Int){
        repeat(size) {
            var dot = Dot()
            dot.statu= "WHITE"
            dot.position =it
            listDots.add(dot)
        }
        getRandom()
        notifyDataSetChanged()
    }

    private fun getRandom() {
        var n = Random().nextInt(listDots.size)
        val randomElement = listDots.filterNot { s -> s.statu == "RED"}.asSequence().shuffled().find { true }
        if (randomElement?.statu=="BLUE") {
            getRandom()
        } else {
            if (randomElement!=null) {
                listDots[randomElement.position!!].statu = "BLUE"
                notifyDataSetChanged()
            }
        }
    }

    fun changeState(dot:Dot,position: Int) {
        this.listDots[position] = dot
        getRandom()
        notifyItemChanged(position)
    }

    class ViewHolder(val binding: RecylerDotBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecylerDotBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(listDots[position].statu) {
            "BLUE"->{
                holder.binding.dotImage.setImageResource(R.drawable.ic_blue)
            }
            "WHITE"->{
                holder.binding.dotImage.setImageResource(R.drawable.ic_white)
            }
            "RED"->{
                holder.binding.dotImage.setImageResource(R.drawable.ic_red)
            }
        }
        holder.binding.dotImage.setOnClickListener {
            if (listDots[position].statu=="BLUE") {
                var dot= Dot()
                dot.statu = "RED"
                dot.position = position
                changeState(dot,position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listDots.size
    }

    interface SetOnDotClickListener{
        fun setDotClickListener(dot: Dot,int:Int)
    }


}