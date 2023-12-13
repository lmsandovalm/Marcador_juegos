package com.laurasando.marcador_juegos.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.laurasando.marcador_juegos.databinding.ItemUserBinding
import com.laurasando.marcador_juegos.models.UserModel

class UserViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemUserBinding.bind(view)
    fun render(userModel: UserModel){
        binding.NameUser.text = userModel.name
        binding.txtPhone.text = userModel.phone
    }
}