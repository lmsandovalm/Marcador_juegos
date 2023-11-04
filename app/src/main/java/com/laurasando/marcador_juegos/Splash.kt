package com.laurasando.marcador_juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.laurasando.marcador_juegos.databinding.ActivitySplashBinding
import com.laurasando.marcador_juegos.ui.MainActivity

class splash : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private val duracion = 3000L;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() = setupJumpNextActivity()

    private fun setupJumpNextActivity() =
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, duracion)
        }

    }
