package com.missclick.gameninja.data.enty

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class EndEntity(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        @ColumnInfo(name = "id")
        var id : Int,

        @ColumnInfo(name = "field")
        var fails : Int,

        )