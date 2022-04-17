package com.yesandroid.kyc.db

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "bank_table")
class Bank(
    @PrimaryKey()

    val pan: String,
    val day: Int,
    val months: Int,
    val year: Int,

    )