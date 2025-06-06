package com.rif.glorygames.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rif.glorygames.core.data.source.local.entity.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

}