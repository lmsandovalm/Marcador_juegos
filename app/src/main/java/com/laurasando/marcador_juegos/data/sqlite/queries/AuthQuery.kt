package com.laurasando.marcador_juegos.data.sqlite.queries

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import com.laurasando.marcador_juegos.data.helpers.Constants.Companion.NAME_TABLE_USER
import com.laurasando.marcador_juegos.data.sqlite.DbManager
import com.laurasando.marcador_juegos.models.UserModel

class AuthQuery (private val context: Context) {

    fun login(usernameOrEmail: String, password: String): UserModel? {
        val dbManager = DbManager(context)
        dbManager.openDbRead()
        val db = dbManager.dbInstance()
        val selection = "(userName = ? OR email = ?) AND password = ?"
        val selectionArgs = arrayOf(usernameOrEmail, usernameOrEmail, password)

        val response = db.query(
            NAME_TABLE_USER, null, selection, selectionArgs, null, null, null
        )
        val user = UserModel()

        if (response.moveToFirst()){
            user.id = response.getString(response.getColumnIndexOrThrow("id")).toInt()
            user.name = response.getString(response.getColumnIndexOrThrow("name"))
            user.identification = response.getString(response.getColumnIndexOrThrow("identification"))
            user.phone = response.getString(response.getColumnIndexOrThrow("phone"))
            user.email = response.getString(response.getColumnIndexOrThrow("email"))
            user.userName = response.getString(response.getColumnIndexOrThrow("userName"))
            user.role = response.getString(response.getColumnIndexOrThrow("role"))

            response.close()
            return user
        } else {
            response.close()
            return null
        }

    }
}