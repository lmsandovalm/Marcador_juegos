package com.laurasando.marcador_juegos.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laurasando.marcador_juegos.R
import com.laurasando.marcador_juegos.models.UserModel

class UserAdapter(private val listUser: List<UserModel>, private val context: Context):
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun getItemCount(): Int= listUser.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(listUser[position])
    }
}