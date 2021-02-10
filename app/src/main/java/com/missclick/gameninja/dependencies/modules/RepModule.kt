package com.missclick.gameninja.dependencies.modules

import android.content.Context
import androidx.room.Room
import com.missclick.gameninja.data.LocalDS
import com.missclick.gameninja.data.RecordsDB
import com.missclick.gameninja.rep.IRep
import com.missclick.gameninja.rep.Rep
import dagger.Module
import dagger.Provides

@Module
class RepModule {
    @Provides
    fun provideIRepository(local : LocalDS) : IRep {
        return Rep(local)
    }

    @Provides
    fun provideLocalDataSource(appContext: Context) : LocalDS{
        val database = Room.databaseBuilder(appContext, RecordsDB::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        return LocalDS(database = database)
    }

}