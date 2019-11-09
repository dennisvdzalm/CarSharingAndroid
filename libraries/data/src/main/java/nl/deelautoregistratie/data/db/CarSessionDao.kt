package nl.deelautoregistratie.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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