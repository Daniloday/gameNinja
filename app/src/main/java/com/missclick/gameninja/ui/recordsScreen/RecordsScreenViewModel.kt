package com.missclick.gameninja.ui.recordsScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.missclick.gameninja.App
import com.missclick.gameninja.data.models.EndModel
import com.missclick.gameninja.rep.IRep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecordsScreenViewModel : ViewModel() {
    // TODO: Implement the ViewModel



    @Inject
    lateinit var rep: IRep

    init {
        App.appComponent.inject(this)
    }

    fun saveResult1(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.getLessonById(1)
            }
        }
    }

    fun saveResult2(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.getResults()
            }
        }
    }

    fun saveResult3(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.deleteAll()
            }
        }
    }

    fun saveResult4(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.deleteLesson(EndModel(fails = 1))
            }
        }
    }
}