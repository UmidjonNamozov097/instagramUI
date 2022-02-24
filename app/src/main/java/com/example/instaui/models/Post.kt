package com.example.instaui.models

class Post {
    var profile: Int = 0
    var fullname: String = ""
    var photo: Int = 0
    var postAll: ArrayList<Int>? = null

    constructor(profile: Int, fullname: String, photo: Int) {
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
    }

    constructor(profile: Int, fullname: String, postAll: ArrayList<Int>) {
        this.profile = profile
        this.fullname = fullname
        this.postAll = postAll
    }
}