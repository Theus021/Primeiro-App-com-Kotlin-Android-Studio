package com.example.alura_tr_mobile1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.alura_tr_mobile1.dao.ProdutosDao
import com.example.alura_tr_mobile1.databinding.ActivityCadastroBinding
import com.example.alura_tr_mobile1.databinding.DialogDeProdutosBinding
import com.example.alura_tr_mobile1.dialog.FormularioDialog
import com.example.alura_tr_mobile1.extension.tentaCarregarImagem
import com.example.alura_tr_mobile1.model.ProdutosModel
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mostrarDialog()

        binding.button.setOnClickListener {
         val dao = ProdutosDao()
         val produtoNovo = criarProduto()
            dao.add(produtoNovo)
            finish()
        }
    }

    private fun criarProduto() : ProdutosModel{
        val nome = binding.textNome.text.toString()
        val categoria = binding.textCategoria.text.toString()
        val valorEmTexto = binding.textValor.text.toString()
        val valor  = if (valorEmTexto.isBlank()){
            BigDecimal.ZERO
        }else{
            BigDecimal(valorEmTexto)
        }

        return ProdutosModel(
            nome = nome,
            categoria = categoria,
            valor = valor,
            imagem = url
        )
    }

    private fun mostrarDialog(){
        binding.imageView2.setOnClickListener {
            FormularioDialog(this).showDialog { imagem ->
                url = imagem
                binding.imageView2.tentaCarregarImagem(url)

            }

        }
    }
}