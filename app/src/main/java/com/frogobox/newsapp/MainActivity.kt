package com.frogobox.newsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogonewsapi.ConsumeNewsApi
import com.frogobox.frogonewsapi.callback.NewsResultCallback
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsUrl
import com.frogobox.recycler.adapter.FrogoRecyclerViewListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTopHeadline()
    }

    private fun setupAdapter(data: List<Article>) {
        val adapter = TopHeadlineAdapter()
        adapter.setupRequirement(
            R.layout.content_item_article,
            data,
            object : FrogoRecyclerViewListener<Article> {
                override fun onItemClicked(data: Article) {
                    Toast.makeText(this@MainActivity, data.description, Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClicked(data: Article) {
                    Toast.makeText(this@MainActivity, data.description, Toast.LENGTH_SHORT).show()
                }
            }
        )
        adapter.setupEmptyView(null) // With Custom View
        rv_news.adapter = adapter
        rv_news.isViewLinearVertical(false)
    }

    private fun getTopHeadline() {
        val consumeNewsApi = ConsumeNewsApi(NewsUrl.NEWS_API_KEY)
        consumeNewsApi.usingChuckInterceptor(this)
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            null,
            null,
            null,
            "id",
            null,
            null,
            object : NewsResultCallback<ArticleResponse> {
                override fun getResultData(data: ArticleResponse) {
                    // Your Ui or data
                    data.articles?.let { setupAdapter(it) }
                }

                override fun failedResult(statusCode: Int, errorMessage: String?) {
                    // Your failed to do
                    Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onShowProgress() {
                    // Your Progress Show
                    Log.d("RxJavaShow", "Show Progress")
                    runOnUiThread {
                        // Stuff that updates the UI
                        progress_view.visibility = View.VISIBLE
                    }
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                    Log.d("RxJavaHide", "Hide Progress")
                    runOnUiThread {
                        // Stuff that updates the UI
                        progress_view.visibility = View.GONE
                    }

                }

            })

    }
}
