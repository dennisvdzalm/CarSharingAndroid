package nl.deelautoregistratie.data.source.app

import io.reactivex.Single
import nl.deelautoregistratie.data.model.mapper.CarSessionMapper
import nl.deelautoregistratie.data.retrofit.services.CarSessionService
import nl.deelautoregistratie.data.source.CarSessionDataSource
import nl.deelautregistratie.domain.model.CarSession
import javax.inject.Inject

class AppCarSessionDataSource @Inject constructor(private val carSessionService: CarSessionService,
                                                  private val carSessionMapper: CarSessionMapper) : CarSessionDataSource {
    override fun getCarSessions(): Single<List<CarSession>> =
            carSessionService.getRecentCarSessions(0)
                    .map { carSessionMapper.transform(it) }
}