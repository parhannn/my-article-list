package com.example.myarticlelist

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myarticlelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvArticle: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataPhoto: TypedArray
    private val list = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

        rvArticle = findViewById(R.id.rv_articles)
        rvArticle.setHasFixedSize(true)

        list.addAll(getListArticle())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvArticle.layoutManager = LinearLayoutManager(this)
        rvArticle.setHasFixedSize(true)
        val listArticleAdapter = ListArticleAdapter(list)
        rvArticle.adapter = listArticleAdapter

        listArticleAdapter.setOnItemClickCallback(object : ListArticleAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Article) {
                showSelectedItem(data)
            }
        })
    }

    private fun getListArticle(): ArrayList<Article> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataLink = resources.getStringArray(R.array.data_link)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo_unglide)
        val lisArticle = ArrayList<Article>()

        for (i in dataName.indices) {
            val article = Article(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataLink[i])
            lisArticle.add(article)
        }

        return lisArticle
    }

    private fun initUI() {
        binding.customToolbar.ivProfile.setOnClickListener() {
            Toast.makeText(this, "Masuk ke Halaman About", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showSelectedItem(article: Article) {
        Toast.makeText(this, "Anda memilih artikel ${article.name}", Toast.LENGTH_SHORT).show()
    }
}