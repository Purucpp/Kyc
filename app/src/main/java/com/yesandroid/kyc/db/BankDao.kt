package com.yesandroid.kyc.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query




@Dao
interface BankDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBank(bank: Bank)


    @Query("SELECT * FROM bank_table")
    fun readAllData(): LiveData<List<Bank>>



}