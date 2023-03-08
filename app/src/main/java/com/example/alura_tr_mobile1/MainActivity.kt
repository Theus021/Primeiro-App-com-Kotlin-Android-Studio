package com.example.alura_tr_mobile1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alura_tr_mobile1.dao.ProdutosDao
import com.example.alura_tr_mobile1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        val recyclerView = binding.recycleListView
        val dao = ProdutosDao()
        dao.buscaTodos()
        recyclerView.adapter = ProdutosAdapter(dao.buscaTodos())
        val intent = Intent(this, CadastroActivity::class.java)

        binding.FAB.setOnClickListener{
            startActivity(intent)
        }
    }
}