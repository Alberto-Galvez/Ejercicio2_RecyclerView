package com.galvezssr.ejercicio2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galvezssr.ejercicio2.databinding.ViewSitioItemBinding
import com.bumptech.glide.Glide

interface SitioClickListener {
    fun onSitioClick (sitio: Sitio)
}

class SitiosAdapter(sitios: List<Sitio>, private val sitioClickListener: SitioClickListener): RecyclerView.Adapter<SitiosAdapter.ViewHolder>() {

    // VARIABLES //////////////////////////
    private val sitios: List<Sitio>

    // INICIALIZADOR //////////////////////
    init {
        this.sitios = sitios
    }

    // FUNCIONES //////////////////////////
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /* Como aqui en el apapter no hay un inflador generalizado, hemos de hacerlo diferente
        * a como lo tenemos en el MainActivity */
        val binding = ViewSitioItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitio = sitios[position]
        holder.bind(sitio)
        holder.itemView.setOnClickListener{sitioClickListener.onSitioClick(sitio)}
    }

    override fun getItemCount(): Int = sitios.size

    // CLASES /////////////////////////////
    class ViewHolder(bind: ViewSitioItemBinding): RecyclerView.ViewHolder(bind.root) {

        // VARIABLES //////////////////////////
        private val bind: ViewSitioItemBinding

        // INICIALIZADOR //////////////////////
        init {
            this.bind = bind
        }

        // FUNCIONES //////////////////////////
        fun bind(sitio: Sitio) {
            bind.boton.text = sitio.nombre
            Glide.with(bind.root.context).load(sitio.imagen).into(bind.imagen)
        }
    }
}