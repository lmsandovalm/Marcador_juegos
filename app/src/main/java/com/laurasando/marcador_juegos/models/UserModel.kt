package com.laurasando.marcador_juegos.models

data class UserModel (
        var id: Int? = null,
        var name: String? = null,
        var identification: String? = null,
        var phone: String? = null,
        var email: String? = null,
        var userName: String? = null,
        var role: String? = null,
        var password: String? = null,
        )