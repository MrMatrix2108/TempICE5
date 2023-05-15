package com.jh2108.retrogsonapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAccessAPI = findViewById<Button>(R.id.btnRetroAPI)

        btnAccessAPI.setOnClickListener(){
            getArticles()
        }
    }

    //replace newsAPI key in ArticlesAPI.kt
    private fun getArticles() {
        val articlesApi = RetrofitHelper.getInstance().create(ArticlesApi::class.java)
        GlobalScope.launch {
            val result = articlesApi.getData()
            val articleList: List<Article>
            val resultBody = result.body()
            if (resultBody != null) {
                val articleList = mutableListOf<Article>()
                for (myData in resultBody.articles){
                    articleList.add(myData)
                }
            }
            Log.d("RESULTS", result.body().toString())
        }
    }
}