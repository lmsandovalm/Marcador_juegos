package com.laurasando.marcador_juegos.models

data class TeamGameModel (
        var id: Int? = null,
        var name: String? = null,
        var gamesPlayed: String? = null,
        var matchesWon: String? = null,
        var lostMatches: String? = null,
        )