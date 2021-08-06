package com.rarited.timescorer.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "time_scorer")
data class TSDataEntity(
    @PrimaryKey @ColumnInfo (name = "ts") val tsName: String,
    @ColumnInfo (name = "scored_time") val scoredTime: Int?,
    @ColumnInfo (name = "priority") val priority: Short?
)