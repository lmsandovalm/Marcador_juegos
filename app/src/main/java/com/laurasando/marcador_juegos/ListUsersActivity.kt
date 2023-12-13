package com.laurasando.marcador_juegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laurasando.marcador_juegos.data.sqlite.queries.UserQuery
import com.laurasando.marcador_juegos.databinding.ActivityListUsersBinding
import com.laurasando.marcador_juegos.ui.adapter.UserAdapter

class ListUsersActivity : AppCompatActivity() {

    private lateinit var userQuery: UserQuery
    private lateinit var binding: ActivityListUsersBinding

    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUsersBinding.inflate(LayoutInflater.from(this))
        userQuery = UserQuery(this)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val listUsers = userQuery.listAllUsers()
        userAdapter = UserAdapter(listUsers, this)
        recyclerView = binding.rvUsers
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,true)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = userAdapter

    }
}