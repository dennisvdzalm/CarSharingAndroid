package nl.deelautoregistratie.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nl.deelautoregistratie.data.model.CarSessionJson

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