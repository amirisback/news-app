package com.frogobox.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.frogobox.frogonewsapi.data.model.Article
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "com.frogobox.newsapp.DetailActivity.extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setupIntentData()
    }

    private fun setupIntentData() {
        val extraData = intent.getStringExtra(EXTRA_DATA)
        val extraArticle = Gson().fromJson(extraData, Article::class.java)
        tv_title.text = extraArticle.title
        tv_source.text = extraArticle.source?.name ?: ""
        tv_content.text = extraArticle.description
        Glide.with(this).load(extraArticle.urlToImage).into(iv_url);
    }


}
