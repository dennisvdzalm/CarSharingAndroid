package nl.deelautoregistratie.data.model.mapper

import nl.deelautoregistratie.data.model.CarSessionJson
import nl.deelautregistratie.domain.model.CarSession
import javax.inject.Inject

class CarSessionMapper @Inject constructor() {

    fun transform(data: List<CarSessionJson>): List<CarSession> {
        return data.map {
            CarSession(
                    id = it.id,
                    userId = it.userId,
                    sharedCarId = it.sharedCarId,
                    start = it.start,
                    end = it.end,
                    description = it.description,
                    mileage = it.mileage
            )
        }
    }

    private val CarSessionJson.mileage: String
        get() = end.minus(start).toString()

}