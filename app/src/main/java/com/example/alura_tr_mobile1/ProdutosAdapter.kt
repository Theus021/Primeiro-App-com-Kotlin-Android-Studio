package com.example.alura_tr_mobile1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.alura_tr_mobile1.databinding.ProdutosListItemBinding
import com.example.alura_tr_mobile1.model.ProdutosModel

class ProdutosAdapter(produtosModel: List<ProdutosModel>) : RecyclerView.Adapter<ProdutosAdapter.produtosVH>() {

    class produtosVH(var binding: ProdutosListItemBinding): RecyclerView.ViewHolder(binding.root)

    var produtosModel = produtosModel.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): produtosVH {
        return produtosVH(ProdutosListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: produtosVH, position: Int) {
        val produtosModel = produtosModel[position]

        holder.binding.textNome.text = produtosModel.nome
        holder.binding.textCategoria.text = produtosModel.categoria
        holder.binding.textValor.text = produtosModel.valor.toPlainString()
        holder.binding.imageView.load(produtosModel.imagem)
    }

    override fun getItemCount(): Int = produtosModel.size

}
