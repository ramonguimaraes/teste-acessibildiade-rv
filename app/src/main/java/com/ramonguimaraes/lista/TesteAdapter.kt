package com.ramonguimaraes.lista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramonguimaraes.lista.databinding.TesteItemBinding

class TesteAdapter(val list: List<Triple<String, String, String>>) :
    RecyclerView.Adapter<TesteAdapter.TesteVH>() {

    inner class TesteVH(private val binding: TesteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Triple<String, String, String>) {
            binding.container.contentDescription = handleAccessibilityText(adapterPosition, item)
            binding.textView.text = item.first
            binding.textView2.text = item.second
            binding.textView3.text = item.third
        }
    }

    private fun handleAccessibilityText(
        adapterPosition: Int,
        item: Triple<String, String, String>
    ): String {
        return when (adapterPosition) {
            0 -> "Primeiro item da lista, item ${adapterPosition + 1} de ${list.size}, ${item.first}, ${item.second}, ${item.third}"
            list.size - 1 -> "Primeiro item da lista, item ${adapterPosition + 1} de ${list.size}, ${item.first}, ${item.second}, ${item.third}"
            else -> "item ${adapterPosition + 1} de ${list.size}, ${item.first}, ${item.second}, ${item.third}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TesteVH {
        val inflater = LayoutInflater.from(parent.context)
        return TesteVH(TesteItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TesteVH, position: Int) {
        holder.bind(list[position])
    }
}