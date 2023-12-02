package com.somensi.orgs.utils

import android.widget.ImageView
import coil.load
import com.somensi.orgs.R

fun ImageView.downloadImage(url: String?) {
    load(url) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }
}