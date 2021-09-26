package com.rarited.timescorer.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class TSRepo(private val tsDao: TSDao) {

    val allTSs: Flow<List<TSDataEntity>> = tsDao.tsGetByName()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun tsInsert(tSDataEntity: TSDataEntity) {
        tsDao.tsInsert(tSDataEntity)
    }
}