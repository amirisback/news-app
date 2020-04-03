package com.frogobox.newsapp.ui.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.newsapp.R
import com.frogobox.newsapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    companion object {
        const val EXTRA_DATA = "com.frogobox.newsapp.activity.DetailActivity.extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setupIntentData()
        setupDetailActivity("Detail Berita")
    }

    private fun setupIntentData() {
        val extraArticle = baseGetExtraData<Article>(EXTRA_DATA)
        tv_title.text = extraArticle.title
        tv_source.text = extraArticle.source?.name ?: ""
        tv_content.text = extraArticle.description
        Glide.with(this).load(extraArticle.urlToImage).into(iv_url);
    }


}
