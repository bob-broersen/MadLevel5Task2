package com.broersen.madlevel5task2.database

import android.content.Context
import androidx.room.*
import com.broersen.madlevel5task2.dao.GameDao
import com.broersen.madlevel5task2.model.Converters
import com.broersen.madlevel5task2.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME ="GAME_DATABASE"

        @Volatile
        private var gameRoomDatabaseInstance: GameDatabase? = null

        fun getDatabase(context: Context): GameDatabase? {
            if(gameRoomDatabaseInstance == null){
                synchronized(GameDatabase::class.java) {
                    if(gameRoomDatabaseInstance == null) {
                        gameRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            GameDatabase::class.java, DATABASE_NAME
                        ).fallbackToDestructiveMigration().build()
                    }
                }
            }
            
            return gameRoomDatabaseInstance
        }
    }
}