package com.missclick.gameninja.data

import android.util.Log
import com.missclick.gameninja.data.enty.EndEntity
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LocalDS(val database : RecordsDB) {

    fun getLessonsAsync() : Deferred<List<EndEntity>> {
        return GlobalScope.async {
            database.resultsDao().getRecord()
        }
    }

    fun insertLessonAsync(finishEntity: EndEntity){
        GlobalScope.async {
            Log.e("repo",finishEntity.toString())
            database.resultsDao().insertRecord(resultEntity = finishEntity)
        }
    }

    fun getResultByIdAsync(lessonId: Int) : Deferred<EndEntity> {
        return GlobalScope.async {
            database.resultsDao().getRecordById(id = lessonId)
        }
    }

    fun deleteResultAsync(dayEntity: EndEntity){
        GlobalScope.async {
            database.resultsDao().removeRecord(dayEntity = dayEntity)
        }
    }

    fun deleteAllLessons(){
        GlobalScope.async {
            database.resultsDao().deleteAllRecords()
        }
    }
}