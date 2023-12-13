package com.laurasando.marcador_juegos.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.laurasando.marcador_juegos.ListUsersActivity
import com.laurasando.marcador_juegos.data.prefs.SharePreferencesManager
import com.laurasando.marcador_juegos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPref: SharePreferencesManager

    private var nomUsuario= ""
    private var contrasena= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        sharedPref= SharePreferencesManager(this)

        setContentView(binding.root)

        initIU()
        }

    private fun initIU() {
        setupListener()
    }

    private fun setupListener() {
        binding.ingresar.setOnClickListener {
            nomUsuario = binding.etUsuario.text.toString()
            contrasena = binding.etContrasena.text.toString()

            if (validateForm()) {
                val intent = Intent(this, Menu::class.java)
                intent.putExtra("nombreUs", nomUsuario)

                sharedPref.savePref("userNameKey", nomUsuario)
                sharedPref.savePref("userPasswordKey", contrasena)
                sharedPref.savePref("userIsLogged", true)

                startActivity(intent)
                loginAuth()
            }
        }
    }

    private fun loginAuth() {
        sharedPref.savePref("userIsLogged", true)
        val intent = Intent(this,ListUsersActivity::class.java)
        startActivity(intent)
        finish()
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