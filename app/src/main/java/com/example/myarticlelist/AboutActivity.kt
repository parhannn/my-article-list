package com.example.myarticlelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myarticlelist.databinding.AboutPageBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: AboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}