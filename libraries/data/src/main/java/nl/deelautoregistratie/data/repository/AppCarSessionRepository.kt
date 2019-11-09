package nl.deelautoregistratie.data.repository

import io.reactivex.Single
import nl.deelautoregistratie.data.source.CarSessionDataSource
import nl.deelautregistratie.domain.model.CarSession
import nl.deelautregistratie.domain.repository.CarSessionRepository
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 28-05-18.
 */
class AppCarSessionRepository @Inject constructor(private val carSessionDataSource: CarSessionDataSource) : CarSessionRepository {

    override fun getCarSessions(): Single<List<CarSession>> {
        return carSessionDataSource.getCarSessions()
    }
}