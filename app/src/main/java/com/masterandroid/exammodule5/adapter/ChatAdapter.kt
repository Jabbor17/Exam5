package com.masterandroid.exammodule5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.masterandroid.exammodule5.R
import com.masterandroid.exammodule5.model.Chat
import java.util.ArrayList

class ChatAdapter (var items: ArrayList<Chat>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_view,parent,false)
        return  MessageViewHolder(view)
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView
        var count: TextView
        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            count = view.findViewById(R.id.tv_count)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is MessageViewHolder){
            val profile = holder.iv_profile
            val fullname = holder.tv_fullname
            val count = holder.count

            profile.setImageResource(chat.profile)
            fullname.setText(chat.fullname)
            count.setText(chat.count.toString())

            if (chat.count > 0){
                count.visibility = View.VISIBLE
            }else{
                count.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return  items.size
    }
}