package com.masterandroid.exammodule5.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masterandroid.exammodule5.HomeActivity
import com.masterandroid.exammodule5.R
import com.masterandroid.exammodule5.adapter.ChatAdapter
import com.masterandroid.exammodule5.model.Chat

class MessagesFragment:Fragment() {
    private val mainActivity: HomeActivity = HomeActivity()
    lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       recyclerView= view.findViewById(R.id.rv_messages)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            refreshAdapter(getAllChats())
        }
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(chats)
        recyclerView.adapter = adapter

    }

    private fun getAllChats(): ArrayList<Chat> {
        val chats:ArrayList<Chat> = ArrayList()

        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",1))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",12))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",0))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",1))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",5))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",1))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",1))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",7))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",0))
        chats.add(Chat(R.drawable.im_man,"Eldor Shomurodov",0))

        return chats

    }


}