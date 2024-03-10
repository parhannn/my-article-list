package com.example.myarticlelist

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myarticlelist.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val KEY_ARTICLE = "key_article"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataArticle = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Article>(KEY_ARTICLE, Article::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Article>(KEY_ARTICLE)
        }

        binding.tvDetailName.text = dataArticle?.name
        binding.tvDetailDescription.text = dataArticle?.description
        binding.ivDetailPhoto.setImageResource(dataArticle!!.photo)
        binding.btnShare.setOnClickListener {
            val share = Intent()
            share.action = Intent.ACTION_SEND
            share.putExtra(Intent.EXTRA_TEXT, dataArticle.link)
            share.type = "text/plain"
            startActivity(Intent.createChooser(share, "Share to:"))
        }
        Toast.makeText(this, "Anda memilih artikel: ${dataArticle.name}", Toast.LENGTH_SHORT).show()
    }
}