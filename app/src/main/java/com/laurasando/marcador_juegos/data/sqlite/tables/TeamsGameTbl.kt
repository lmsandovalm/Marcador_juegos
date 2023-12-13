package com.laurasando.marcador_juegos.data.sqlite.tables

import com.laurasando.marcador_juegos.data.helpers.Constants.Companion.NAME_TABLE_USER

class TeamsGameTbl {
    companion object {
        const val CREATE_TEAM_TABLE = " CREATE TABLE $NAME_TABLE_USER" +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL , " +
                "gamesPlayed TEXT NOT NULL, " +
                "matchesWon TEXT NOT NULL ," +
                "lostMatches TEXT NOT NULL ) "

        const val SELECT_TEAM_TABLE =
            "SELECT * FROM $NAME_TABLE_USER"

    }
}