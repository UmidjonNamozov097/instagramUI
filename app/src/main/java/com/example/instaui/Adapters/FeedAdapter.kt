package com.example.instagramuiproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.instaui.R
import com.example.instaui.models.Feed
import com.example.instaui.models.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var items:ArrayList<Feed>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        var TYPE_ITEM_STORY = 0
        var TYPE_ITEM_POST = 1
        var TYPE_ITEM_POST_ALL = 2
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].stories.size>0){
            return TYPE_ITEM_STORY
        } else if (items[position].post!!.postAll!=null){
            return TYPE_ITEM_POST_ALL
        } else return TYPE_ITEM_POST
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story,parent,false)
            return StoryViewHolder(context,view)
        } else if (viewType == TYPE_ITEM_POST_ALL) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_all_recyclerview,parent,false)
            return PostAllViewHolder(context,view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post,parent,false)
        return PosterViewHolder(view)
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is   StoryViewHolder) {
            var recyclerView = holder.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false )
            refreshAdapter(feed.stories, recyclerView)

        }
        if (holder is  PosterViewHolder){
            holder.apply {
                iv_profile.setImageResource(feed.post!!.profile)
            }
        }

        if (holder is PostAllViewHolder){
            var recyclerView = holder.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false )
            refreshPostAdapter(feed.post!!.postAll!!, recyclerView)
            var snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
        }
    }

    fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView){
        val adapter = StoryAdapter(context, stories)
        recyclerView!!.adapter = adapter
    }

    fun refreshPostAdapter(postALL: ArrayList<Int>, recyclerView: RecyclerView){
        val adapter = PostAllAdapter(context, postALL)
        recyclerView!!.adapter = adapter
    }

    class PosterViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        var iv_photo = view.findViewById<ImageView>(R.id.iv_photo)
        var iv_like = view.findViewById<ImageView>(R.id.iv_like)
        var iv_comment = view.findViewById<ImageView>(R.id.iv_comment)
        var iv_send = view.findViewById<ImageView>(R.id.iv_send)
        var tv_fullname = view.findViewById<TextView>(R.id.fullname)

    }

    class PostAllViewHolder(context: Context, view: View):RecyclerView.ViewHolder(view) {
        var recyclerView:RecyclerView
        init {
            recyclerView = view.findViewById(R.id.recyclerViewAllPost)
        }
    }

    class StoryViewHolder(context: Context, view: View):RecyclerView.ViewHolder(view) {
        var recyclerView:RecyclerView
        init {
            recyclerView = view.findViewById(R.id.recyclerView)
        }
    }





}
