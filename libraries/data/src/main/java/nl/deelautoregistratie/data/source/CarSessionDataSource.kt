package nl.deelautoregistratie.data.source

import io.reactivex.Single
import nl.deelautregistratie.domain.model.CarSession

interface CarSessionDataSource {

    fun getCarSessions(): Single<List<CarSession>>
}