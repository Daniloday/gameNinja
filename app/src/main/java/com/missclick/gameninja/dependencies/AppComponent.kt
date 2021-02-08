package com.missclick.gameninja.dependencies

import com.missclick.gameninja.dependencies.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent{

}