package com.missclick.gameninja.data

import androidx.room.*
import com.missclick.gameninja.data.enty.EndEntity

@Dao
interface RecordsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(resultEntity: EndEntity)

    @Query("SELECT * FROM records")
    fun getRecord() : List<EndEntity>

    @Query("SELECT * FROM records WHERE id = :id")
    fun getRecordById(id : Int) : EndEntity

    @Delete
    fun removeRecord(dayEntity: EndEntity)

    @Query("DELETE FROM records")
    fun deleteAllRecords()


}