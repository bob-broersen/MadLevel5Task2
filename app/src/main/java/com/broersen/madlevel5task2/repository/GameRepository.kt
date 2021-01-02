package com.broersen.madlevel5task2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.broersen.madlevel5task2.dao.GameDao
import com.broersen.madlevel5task2.database.GameDatabase
import com.broersen.madlevel5task2.model.Game

class GameRepository(context: Context) {
    private var gameDao: GameDao

    init {
        val gameDatabase = GameDatabase.getDatabase(context)
        gameDao = gameDatabase!!.gameDao()
    }

    fun getAllGames(): LiveData<List<Game>> {
        return gameDao.getAllGames()
    }

    suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

    suspend fun  deleteAllGames(){
        gameDao.deleteAllGames()
    }
}