package com.example.alura_tr_mobile1.dao

import com.example.alura_tr_mobile1.model.ProdutosModel

class ProdutosDao() {

    companion object{
        private val produtos = mutableListOf<ProdutosModel>()
    }

    fun add(produto:ProdutosModel){
        produtos.add(produto)
    }

    fun buscaTodos(): List<ProdutosModel> {
        return produtos.toList()
    }



}