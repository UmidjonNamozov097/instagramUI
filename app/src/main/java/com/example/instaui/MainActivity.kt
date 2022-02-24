package com.example.instaui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramuiproject.adapter.FeedAdapter
import com.example.instaui.models.Feed
import com.example.instaui.models.Post
import com.example.instaui.models.Story

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllFeed())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }

    fun getAllFeed():ArrayList<Feed> {

        val stories = ArrayList<Story>()

        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))
        stories.add(Story(R.drawable.img,"Umid Namozov"))

        val feeds:ArrayList<Feed> = ArrayList()

        feeds.add(Feed(stories))

        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov", arrayListOf(R.drawable.img_3,R.drawable.img_3))))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))
        feeds.add(Feed(Post(R.drawable.img_2,"Umid Namozov",R.drawable.img_3)))

        return feeds

    }
}