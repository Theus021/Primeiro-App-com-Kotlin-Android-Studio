package com.example.alura_tr_mobile1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alura_tr_mobile1.databinding.ActivityMainBinding
import com.example.alura_tr_mobile1.model.produtosModel
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView = binding.recycleListView
        recyclerView.adapter = ProdutosAdapter(listOf(
            produtosModel(
                "Iphone 12",
                "Celular",
                BigDecimal("4999.99")),
            produtosModel(
                "Samsung m30",
                "celular",
                BigDecimal("1499.99")),
            produtosModel(
                "Hawai 40",
                "celular",
                BigDecimal("3499.99")),
            produtosModel(
                "moto g 5 plus",
                "celular",
                BigDecimal("899.99")),
            
        ))
    }
}