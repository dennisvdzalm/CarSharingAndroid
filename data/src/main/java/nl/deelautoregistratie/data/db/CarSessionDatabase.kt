package nl.deelautoregistratie.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import nl.deelautoregistratie.data.model.CarSessionJson
import nl.deelautregistratie.domain.model.CarSession

@Database(entities = [(CarSessionJson::class)], version = 1, exportSchema = false)
abstract class CarSessionDatabase : RoomDatabase() {

    abstract fun carSessionDao(): CarSessionDao

    companion object {

        @Volatile
        private var INSTANCE: CarSessionDatabase? = null

        fun getInstance(context: Context): CarSessionDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context,
                        CarSessionDatabase::class.java, "carsession.db")
                        .fallbackToDestructiveMigration()
                        .build()
    }
}