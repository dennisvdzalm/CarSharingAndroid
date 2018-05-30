package nl.deelautoregistratie.deelautoapp.data.db

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import nl.deelautoregistratie.deelautoapp.data.model.CarSession

@Dao
interface CarSessionDao {

    @Query("SELECT * FROM carsessions")
    fun getAllCarSessions(): DataSource.Factory<Int, CarSession>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCarSessions(carSession: List<CarSession>)

    @Query("DELETE FROM carsessions")
    fun deleteCarSessions()
}