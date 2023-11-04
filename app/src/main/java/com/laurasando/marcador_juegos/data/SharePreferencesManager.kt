package com.laurasando.marcador_juegos.data

import android.content.Context
import android.content.SharedPreferences

class SharePreferencesManager (context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("DB_CLASE1", Context.MODE_PRIVATE)
    }

    fun saveUserName(username: String) {
        val editor = sharedPreferences.edit()
        editor.putString("keyUserName", username)
        editor.apply()
    }

    fun getUserName(): String =
        sharedPreferences.getString("keyUserName","Sin datos").toString()

}