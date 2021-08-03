package com.rarited.timescorer.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TSDao {
    @Query("SELECT * FROM time_scorer ORDER BY ts ASC")
    fun tsGetByName(): Flow<List<TSDataEntity>>

    @Query("SELECT * FROM time_scorer WHERE ts LIKE :name")
    fun tsFindByName(name: String): TSDataEntity

    @Query("SELECT * FROM time_scorer ORDER BY ts DESC")
    fun tsGetByPriority(): List<TSDataEntity>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun tsInsert(entity: TSDataEntity)

    @Query("DELETE FROM time_scorer")
    suspend fun deleteAll()

    @Delete
    fun tsDelete(entity: TSDataEntity)
}