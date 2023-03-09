package com.example.alura_tr_mobile1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import coil.load
import com.example.alura_tr_mobile1.dao.ProdutosDao
import com.example.alura_tr_mobile1.databinding.ActivityCadastroBinding
import com.example.alura_tr_mobile1.databinding.DialogDeProdutosBinding
import com.example.alura_tr_mobile1.model.ProdutosModel
import java.math.BigDecimal

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var dialog: AlertDialog
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
            showDialog()
        }
    }private fun showDialog(){
        val build = AlertDialog.Builder(this)
        val dialogBinding = DialogDeProdutosBinding.inflate(layoutInflater)

        dialogBinding.confirmarBtn.setOnClickListener {
            val url = dialogBinding.inputUrl.text.toString()
            dialogBinding.imageDoDialog.load(url){
                placeholder(R.drawable.avatar)
            }
        }

        build.setView(dialogBinding.root)


            .setPositiveButton("confirmar"){_,_, ->
                url = dialogBinding.inputUrl.text.toString()
                binding.imageView2.load(url){
                    placeholder(R.drawable.avatar)
                }
            }

            .setNegativeButton("cancelar"){_,_, ->
                dialog.dismiss()
            }

        dialog = build.create()
        dialog.show()

    }

}