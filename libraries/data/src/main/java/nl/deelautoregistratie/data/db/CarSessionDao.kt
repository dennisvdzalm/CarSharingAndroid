package nl.deelautoregistratie.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import nl.deelautoregistratie.data.model.CarSessionJson

@Dao
interface CarSessionDao {

    @Query("SELECT * FROM carsessions")
    fun getAllCarSessions(): List<CarSessionJson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCarSessions(carSession: List<CarSessionJson>)

    @Query("DELETE FROM carsessions")
    fun deleteCarSessions()
}