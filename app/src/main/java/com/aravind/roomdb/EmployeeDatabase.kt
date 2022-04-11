package com.aravind.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDao(): DAO

    companion object {

        @Volatile
        var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase? {

            var instance = INSTANCE

            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EmployeeDatabase::class.java,
                        "employee_table"
                    ).fallbackToDestructiveMigration()
                        .build()
                }

                INSTANCE = instance
            }
            return instance
        }
    }
}