package com.laurasando.marcador_juegos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.laurasando.marcador_juegos.databinding.ActivityMarcadorBinding

class Marcador : AppCompatActivity() {
    private lateinit var binding: ActivityMarcadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMarcadorBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initIU()
    }

    private fun initIU() {
        funSet()
        funLocal()
        funVis()
    }

    private fun funVis() {
        binding.btnMarcadorVisitante.setOnClickListener {

        }
    }

    private fun funLocal() {

    }

    private fun funSet() {

    }

}