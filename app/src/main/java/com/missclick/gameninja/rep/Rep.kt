package com.missclick.gameninja.rep

import com.missclick.gameninja.data.LocalDS
import com.missclick.gameninja.data.enty.EndEntity
import com.missclick.gameninja.data.models.EndModel

class Rep(var local : LocalDS): IRep {

    override suspend fun getResults() : List<EndModel> {
        val lessonEntities =  local.getLessonsAsync().await()
        val lessonModels = mutableListOf<EndModel>()
        for(lesson in lessonEntities)
            lessonModels.add(
                EndModel(
                fails = lesson.fails
            ))
        return lessonModels
    }

    override fun insertResult(result : EndModel) {
        val lessonEntity = EndEntity(fails = result.fails, id  = 1)
        local.insertLessonAsync(finishEntity = lessonEntity)

    }

    override suspend fun getLessonById(id : Int) : EndModel {
        val entity = local.getResultByIdAsync(lessonId = id).await()
        return EndModel(
            fails = entity.fails
        )
    }

    override suspend fun deleteLesson(result: EndModel) {
        local.deleteResultAsync(dayEntity = EndEntity(fails = result.fails, id = 1))
    }

    override suspend fun deleteAll(){
        local.deleteAllLessons()
    }

}