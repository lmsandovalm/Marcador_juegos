package com.laurasando.marcador_juegos.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.laurasando.marcador_juegos.data.SharePreferencesManager
import com.laurasando.marcador_juegos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPref: SharePreferencesManager
    private var nomUsuario= ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        sharedPref= SharePreferencesManager(this)

        setContentView(binding.root)

        val usernamePref = sharedPref.getUserName()
        Toast.makeText(this, usernamePref, Toast.LENGTH_SHORT).show()

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

                sharedPref.saveUserName(nomUsuario)

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