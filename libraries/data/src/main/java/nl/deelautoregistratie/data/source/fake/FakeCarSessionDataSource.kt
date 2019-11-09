package nl.deelautoregistratie.data.source.fake

import io.reactivex.Single
import nl.deelautoregistratie.data.source.CarSessionDataSource
import nl.deelautregistratie.domain.model.CarSession
import javax.inject.Inject

class FakeCarSessionDataSource @Inject constructor() : CarSessionDataSource {
    override fun getCarSessions(): Single<List<CarSession>> {
        return Single.just(listOf(
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit"),
                CarSession(id = 0, userId = 1, sharedCarId = 1, start = 200, end = 300, mileage = "200", description = "Testrit")
        ))
    }
}