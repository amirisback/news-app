package com.frogobox.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frogobox.frogonewsapi.ConsumeNewsApi
import com.frogobox.frogonewsapi.callback.NewsResultCallback
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsUrl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                    }

                    override fun failedResult(statusCode: Int, errorMessage: String?) {
                        // Your failed to do
                    }

                    override fun onShowProgress() {
                        // Your Progress Show
                    }

                    override fun onHideProgress() {
                        // Your Progress Hide
                    }

                })

    }
}
