package com.example.instagramuiproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instaui.R

class PostAllAdapter(var context: Context, var items:ArrayList<Int>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_all,parent,false)
        return PhotoAllViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is PhotoAllViewHolder) {
            var iv_profile = holder.iv_profile
            var tv_count = holder.tv_count
            tv_count.text = "${position+1}/${items.size}"

            iv_profile.setImageResource(item)

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PhotoAllViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var iv_profile: ImageView
        var tv_count= view.findViewById<TextView>(R.id.tv_count_photo)

        init {
            iv_profile = view.findViewById(R.id.iv_photo_all)

        }

    }
}