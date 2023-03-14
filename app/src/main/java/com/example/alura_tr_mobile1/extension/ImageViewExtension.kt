package com.example.alura_tr_mobile1.extension

import android.widget.ImageView
import coil.load
import com.example.alura_tr_mobile1.R

fun ImageView.tentaCarregarImagem(url: String? = null){

    load(url){
        placeholder(R.drawable.placeholder)
        fallback(R.drawable.avatar)
        error(R.drawable.error)
    }

}