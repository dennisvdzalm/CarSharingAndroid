package nl.deelautoregistratie.deelautoapp.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import nl.deelautoregistratie.deelautoapp.data.model.CarSession

@Dao
interface CarSessionDao {

    @Query("SELECT * FROM carsessions")
    fun getAllCarSessions(): Flowable<List<CarSession>>

    @Query("SELECT * FROM carsessions WHERE id = :id")
    fun getCarSessionById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCarSession(carSession: CarSession)

    @Query("DELETE FROM carsessions")
    fun deleteCarSessions()
}