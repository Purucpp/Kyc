package com.yesandroid.kyc.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Bank::class], version = 1, exportSchema = false)
abstract class BankDatabase : RoomDatabase() {

    abstract fun bankDao(): BankDao

    companion object
    {
        @Volatile
        private var INSTANCE: BankDatabase? = null

        fun getDatabase(context: Context): BankDatabase
        {
            val tempInstance = INSTANCE
            if(tempInstance != null)
            {
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BankDatabase::class.java,
                    "bank_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}