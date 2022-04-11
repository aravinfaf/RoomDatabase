package com.aravind.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {

    @Insert
    suspend fun insert(employee: Employee)

    @Update
    suspend fun update(employee: Employee)

    @Query("SELECT * FROM 'employee_table'")
    fun getAllEmployees() : Flow<List<Employee>>

    @Query("SELECT * FROM 'employee_table' WHERE id = 'id'")
    fun getEmployee(id : Int) : Flow<Employee>

}