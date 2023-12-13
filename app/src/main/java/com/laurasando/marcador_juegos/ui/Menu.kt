package com.laurasando.marcador_juegos.ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laurasando.marcador_juegos.data.prefs.SharePreferencesManager
import com.laurasando.marcador_juegos.databinding.ActivityMenuBinding
import com.laurasando.marcador_juegos.ui.game.TeamPlanningActivity

class Menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var sharedPref: SharePreferencesManager
    private var nomUsuario = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        sharedPref = SharePreferencesManager(this)
        setContentView(binding.root)

        initUI()

        binding.iniciarMarcador.setOnClickListener {
            val intent = Intent(this, Marcador::class.java)
            startActivity(intent)
        }

        binding.btnHistorial.setOnClickListener {
            val intent = Intent(this, Historial_marcador::class.java)
            startActivity(intent)
        }

    }

    private fun initUI() {
        setupGetExtras()
        setupGetPref()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.iniciarMarcador.setOnClickListener {
            val intent = Intent(this, TeamPlanningActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setupGetPref() {
        nomUsuario = sharedPref.getPref("userNameKey", "Empty").toString()
        binding.txtNombreUsuario.text = nomUsuario
    }

    private fun setupGetExtras() {
        nomUsuario = intent.getStringExtra("nombreUs").toString()
        binding.txtNombreUsuario.text = nomUsuario
    }



    override fun onCreateDialog(id: Int): Dialog {
        return super.onCreateDialog(id)
    }


}