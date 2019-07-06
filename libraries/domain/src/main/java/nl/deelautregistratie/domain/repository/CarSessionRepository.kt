package nl.deelautregistratie.domain.repository

import io.reactivex.Single
import nl.deelautregistratie.domain.model.CarSession

interface CarSessionRepository {
    fun getCarSessions(): Single<List<CarSession>>
}