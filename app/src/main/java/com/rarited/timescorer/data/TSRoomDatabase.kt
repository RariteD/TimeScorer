package com.rarited.timescorer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [TSDataEntity::class], version = 1)
abstract class TSRoomDatabase : RoomDatabase() {
    abstract fun tsDao(): TSDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: TSRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): TSRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TSRoomDatabase::class.java,
                    "timer_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(TSDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
    private class TSDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.tsDao())
                }
            }
        }

        suspend fun populateDatabase(tsDao: TSDao) {
            // Delete all content here.
            tsDao.deleteAll()

            // Add sample words.
            var timer = TSDataEntity( "hello...",0,0)
            tsDao.tsInsert(timer)
            timer = TSDataEntity("its me...",0,0)
            tsDao.tsInsert(timer)
        }
    }
}