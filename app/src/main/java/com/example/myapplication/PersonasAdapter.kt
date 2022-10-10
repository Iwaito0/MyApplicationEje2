package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ViewPersonaItemBinding




class PersonasAdapter(
    private val personas: List<Persona>,
    private val personaClickedListener:  (Persona) -> Unit
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
            val persona = personas[position]
            holder.bind(persona)
            holder.itemView.setOnClickListener { personaClickedListener(persona) }
    }

    override fun getItemCount(): Int {
        return personas.size
    }


    class ViewHolder(private val binding: ViewPersonaItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(persona: Persona){
            Glide
                .with(binding.root.context)
                .load(persona.uImagen)
                .into(binding.imagenPer)
            binding.textNombre.text = persona.nombre
            binding.textTelefono.text =persona.telefono
            binding.textCorreo.text=persona.correo
        }
    }

}