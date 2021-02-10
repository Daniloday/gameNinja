package com.missclick.gameninja.rep

import com.missclick.gameninja.data.models.EndModel

interface IRep {

    fun insertResult(result : EndModel)
    suspend fun getResults() : List<EndModel>
    suspend fun getLessonById(id : Int) : EndModel
    suspend fun deleteLesson(result: EndModel)
    suspend fun deleteAll()

}