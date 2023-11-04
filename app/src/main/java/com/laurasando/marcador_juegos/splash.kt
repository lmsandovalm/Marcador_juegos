package com.laurasando.marcador_juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.laurasando.marcador_juegos.databinding.ActivitySplashBinding

class splash : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    val duracion: Long = 3000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val pantSpla = binding.splash
        Glide.with(this).load(R.drawable.vclub).into(pantSpla)

        cambiarActivity()
    }

    private fun cambiarActivity() {
        Handler().postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, duracion)
    }
}