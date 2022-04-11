package com.aravind.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_table")
data class Employee(
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    val email: String = ""
)
