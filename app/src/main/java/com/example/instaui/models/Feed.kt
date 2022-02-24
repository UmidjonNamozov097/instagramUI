package com.example.instaui.models

class Feed {
    var post: Post? =null
    var stories:ArrayList<Story> = ArrayList()

    constructor(post: Post){
        this.post = post
    }
    constructor(story: ArrayList<Story>){
        this.stories=story
    }
}