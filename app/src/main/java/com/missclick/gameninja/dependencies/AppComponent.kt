package com.missclick.gameninja.dependencies

import com.missclick.gameninja.dependencies.modules.AppModule
import com.missclick.gameninja.dependencies.modules.RepModule
import com.missclick.gameninja.ui.firstScreen.FirstScreenViewModel
import com.missclick.gameninja.ui.gameScreen.GameScreenViewModel
import com.missclick.gameninja.ui.recordsScreen.RecordsScreenViewModel
import com.missclick.gameninja.ui.resultScreen.ResultScreenViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RepModule::class])
@Singleton
interface AppComponent{
    fun inject(endViewModel: ResultScreenViewModel)
    fun inject(firstViewModel: FirstScreenViewModel)
    fun inject(recViewModel: GameScreenViewModel)
    fun inject(recordsViewModel: RecordsScreenViewModel)
}