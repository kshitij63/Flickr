package com.loktra_assign2.flickr

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)

        var list = ArrayList<ImagePOJO>()
        list.add(ImagePOJO(resources.getDrawable(R.drawable.taj)
                , resources.getDrawable(R.drawable.indiagate),"This is Taj mahal","This is India gate"))
        list.add(ImagePOJO(resources.getDrawable(R.drawable.redfort)
                , resources.getDrawable(R.drawable.liberty),"This is Red Fort","This is Statue of Liberty"))
        recyclerview.adapter = FlickrAdapter(this, recyclerview,list)

    }
}
