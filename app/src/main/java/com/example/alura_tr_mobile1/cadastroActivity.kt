package com.example.alura_tr_mobile1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alura_tr_mobile1.databinding.ActivityCadastroBinding

class cadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        
        setContentView(binding.root)
    }
}