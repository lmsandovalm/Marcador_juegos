package com.laurasando.marcador_juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.laurasando.marcador_juegos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var nomUsuario= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initIU()
        }

    private fun initIU() {
        setupListener()
    }

    private fun setupListener() {
        binding.ingresar.setOnClickListener {
            nomUsuario = binding.etUsuario.text.toString()

            if (validateForm()) {
                val intent = Intent(this, Menu::class.java)
                intent.putExtra("nombreUs", nomUsuario)
                startActivity(intent)
            }
        }
    }


    private fun validateForm(): Boolean {
    return if (binding.etUsuario.text.toString().isEmpty()){
        Toast.makeText(this, "Digita tu usuario", Toast.LENGTH_SHORT).show()
        false
    }else{
        true
    }
    }

}