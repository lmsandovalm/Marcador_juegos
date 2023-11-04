package com.laurasando.marcador_juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laurasando.marcador_juegos.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private var nomUsuario = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        binding.iniciarMarcador.setOnClickListener {
            val intent=Intent(this,Marcador::class.java)
            startActivity(intent)
        }

        binding.btnHistorial.setOnClickListener {
            val intent=Intent(this, Historial_marcador::class.java)
            startActivity(intent)
        }

    }

    private fun initUI() {
        setupGetExtras()
    }

    private fun setupGetExtras() {
        nomUsuario= intent.getStringExtra("nombreUs").toString()
        binding.txtNombreUsuario.text = nomUsuario
    }




}