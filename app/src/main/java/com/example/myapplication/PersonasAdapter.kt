package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ViewPersonaItemBinding




class PersonasAdapter(
    private val ubicacions: List<Ubicacion>,
    private val personaClickedListener:  (Ubicacion) -> Unit
    ):
    RecyclerView.Adapter<PersonasAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ViewPersonaItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false

        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val persona = ubicacions[position]
            holder.bind(persona)
            holder.itemView.setOnClickListener { personaClickedListener(persona) }
    }

    override fun getItemCount(): Int {
        return ubicacions.size
    }


    class ViewHolder(private val binding: ViewPersonaItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(ubicacion: Ubicacion){
            Glide
                .with(binding.root.context)
                .load(ubicacion.uImagen)
                .into(binding.imagenPer)
            binding.textNombre.text = ubicacion.nombre
        }
    }

}