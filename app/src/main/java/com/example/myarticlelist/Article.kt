package com.example.myarticlelist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val name: String,
    val description: String,
    val photo: Int,
    val link: String
): Parcelable
