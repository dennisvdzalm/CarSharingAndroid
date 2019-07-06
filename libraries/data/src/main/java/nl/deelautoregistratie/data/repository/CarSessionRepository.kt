package nl.deelautoregistratie.data.repository

import io.reactivex.Single
import nl.deelautoregistratie.data.db.CarSessionDatabase
import nl.deelautoregistratie.data.model.mapper.CarSessionMapper
import nl.deelautoregistratie.data.retrofit.services.CarSessionService
import nl.deelautregistratie.domain.model.CarSession
import nl.deelautregistratie.domain.repository.CarSessionRepository
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 28-05-18.
 */
class CarSessionRepository @Inject constructor(private val apiService: CarSessionService,
                                               private val mapper: CarSessionMapper,
                                               private val db: CarSessionDatabase) : CarSessionRepository {

    override fun getCarSessions(): Single<List<CarSession>> {
        return apiService.getRecentCarSessions(0)
                .doAfterSuccess { db.carSessionDao().insertCarSessions(it) }
                .map { mapper.transform(it) }
    }
}