package com.missclick.gameninja.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.missclick.gameninja.data.enty.EndEntity

@Database(entities = [EndEntity::class], version = 3)
abstract class RecordsDB : RoomDatabase(){
    abstract fun resultsDao() : RecordsDao

}