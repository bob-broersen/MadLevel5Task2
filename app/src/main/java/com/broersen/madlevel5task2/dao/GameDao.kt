package com.broersen.madlevel5task2.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.broersen.madlevel5task2.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM gameTable")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllGames()
}