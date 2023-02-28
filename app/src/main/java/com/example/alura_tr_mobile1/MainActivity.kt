package com.example.alura_tr_mobile1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alura_tr_mobile1.databinding.ActivityMainBinding
import com.example.alura_tr_mobile1.model.ProdutosModel
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recycleListView
        recyclerView.adapter = ProdutosAdapter(listOf(
            ProdutosModel(
                "Iphone 12",
                "Celular",
                BigDecimal("4999.99")),
            ProdutosModel(
                "Samsung m30",
                "celular",
                BigDecimal("1499.99")),
            ProdutosModel(
                "Hawai 40",
                "celular",
                BigDecimal("3499.99")),
            ProdutosModel(
                "moto g 5 plus",
                "celular",
                BigDecimal("899.99")),
            
        ))

        val intent = Intent(this, cadastroActivity::class.java)

        binding.FAB.setOnClickListener{
            startActivity(intent)
        }
    }
}