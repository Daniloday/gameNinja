package com.missclick.gameninja.dependencies.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RepModule::class])
class AppModule(context: Context) {

    private var appContext : Context = context

    @Provides
    @Singleton
    fun provideContext() : Context{
        return appContext
    }

}