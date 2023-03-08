package com.example.alura_tr_mobile1.model

import java.math.BigDecimal

data class ProdutosModel(
    var nome: String,
    var categoria: String,
    var valor: BigDecimal,
    var imagem: String?
)
