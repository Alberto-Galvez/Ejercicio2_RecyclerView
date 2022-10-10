package com.galvezssr.ejercicio2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.galvezssr.ejercicio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = SitiosAdapter(
            listOf(
                Sitio("Francia", "https://co.ambafrance.org/IMG/jpg/5af8fbe3-1c69-4f0b-8e22-6e156208a52e.jpg?17779/307fc07ddf7b8e65ef44de5b7ba62c510ac68a72", "46.646657804040395, 2.4417065499651436"),
                Sitio("Dinamarca", "https://elviajerofeliz.com/wp-content/uploads/2021/03/ciudades-de-dinamarca.jpg", "55.59653945692017, 9.639149059894653"),
                Sitio("Egipto", "https://www.egiptoexclusivo.com/wp-content/uploads/2020/12/antiguo-egipto.jpg", "26.658354314398775, 29.787958496211246"),
                Sitio("Corea del Norte", "https://www.lavanguardia.com/files/content_image_mobile_filter/uploads/2018/09/17/5fa44b2c9b9ab.jpeg", "40.15288764320692, 127.12538038621877"),
                Sitio("Chile", "https://a.cdn-hotels.com/gdcs/production162/d454/b70026db-db9b-42e5-86ab-17c066571d32.jpg?impolicy=fcrop&w=800&h=533&q=medium", "-26.647136971077344, -69.8602530808112"),
                Sitio("Canadá", "https://a.cdn-hotels.com/gdcs/production159/d204/01ae3fa0-c55c-11e8-9739-0242ac110006.jpg", "60.312424832877895, -112.36392406529376")
            ),
            object : SitioClickListener {
                override fun onSitioClick(sitio: Sitio) {
                    val direccion = sitio.cordenadas
                    val map = "http://maps.google.com/maps?q=$direccion"
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(map))
                    startActivity(i)
                }

            }
        )
    }
}