package nl.deelautregistratie.domain.model

data class CarSession(
        val id: Int,
        val userId: Int,
        val sharedCarId: Int,
        val start: Int,
        val end: Int,
        val mileage: String,
        val description: String
)