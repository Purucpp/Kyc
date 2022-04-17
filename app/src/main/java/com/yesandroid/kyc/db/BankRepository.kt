package com.yesandroid.kyc.db

import androidx.lifecycle.LiveData




class BankRepository(private val bankDao: BankDao)
{

    val readAllData: LiveData<List<Bank>> = bankDao.readAllData()
    suspend fun addBank(bank: Bank){
        bankDao.addBank(bank)
    }


}