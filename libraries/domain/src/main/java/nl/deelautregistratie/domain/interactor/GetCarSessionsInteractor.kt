package nl.deelautregistratie.domain.interactor

import io.reactivex.Single
import nl.deelautregistratie.domain.model.CarSession
import nl.deelautregistratie.domain.repository.CarSessionRepository
import javax.inject.Inject

class GetCarSessionsInteractor @Inject constructor(private val repository: CarSessionRepository) {

    fun prepare(requestValues: RequestValues): Single<List<CarSession>> {
        return repository.getCarSessions()
    }

    class RequestValues(val page: Int)
}