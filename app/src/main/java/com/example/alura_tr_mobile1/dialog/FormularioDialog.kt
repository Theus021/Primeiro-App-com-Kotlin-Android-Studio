package com.example.alura_tr_mobile1.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alura_tr_mobile1.databinding.DialogDeProdutosBinding
import com.example.alura_tr_mobile1.extension.tentaCarregarImagem

class FormularioDialog (private val context: Context) {

    private lateinit var dialog: AlertDialog

     fun showDialog(quandoCarregada:(imagem:String) -> Unit){

        val build = AlertDialog.Builder(context)
        val dialogBinding = DialogDeProdutosBinding.inflate(LayoutInflater.from(context))


        dialogBinding.confirmarBtn.setOnClickListener {
            val url = dialogBinding.inputUrl.text.toString()
            if (url.isNullOrEmpty()){
                Toast.makeText(context, "Digite uma URL válida", Toast.LENGTH_SHORT).show()
            }
            else{
                dialogBinding.imageDoDialog.tentaCarregarImagem(url)
            }
        }

        build.setView(dialogBinding.root)

            .setPositiveButton("confirmar"){_,_, ->
                val url = dialogBinding.inputUrl.text.toString()
                quandoCarregada(url)

            }

            .setNegativeButton("cancelar"){_,_, ->
                dialog.dismiss()
            }

        dialog = build.create()
        dialog.show()

    }
}