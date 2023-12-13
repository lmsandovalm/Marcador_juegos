package com.laurasando.marcador_juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.laurasando.marcador_juegos.data.prefs.SharePreferencesManager
import com.laurasando.marcador_juegos.databinding.ActivitySplashBinding
import com.laurasando.marcador_juegos.ui.MainActivity
import com.laurasando.marcador_juegos.ui.Menu

class splash : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private lateinit var sharedPref : SharePreferencesManager

    private val duracion = 3000L;
    private var userIsLogged = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(LayoutInflater.from(this))
        sharedPref = SharePreferencesManager(this)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        setupJumpNextActivity()
        setupGetPrefs()
    }

    private fun setupGetPrefs() {
        userIsLogged = sharedPref.getPref("userIsLogged", false) as Boolean
    }

    private fun setupJumpNextActivity() =
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                if (userIsLogged){
                    val intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }, duracion)
        }

    }
