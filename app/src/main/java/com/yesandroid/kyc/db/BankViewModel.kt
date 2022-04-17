package com.yesandroid.kyc.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BankViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Bank>>
    private val repository: BankRepository

    init {
        val bankDao = BankDatabase.getDatabase(
            application
        ).bankDao()
        repository = BankRepository(bankDao)
        readAllData = repository.readAllData
    }

     fun addBank(bank: Bank)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBank(bank)
        }
    }

}