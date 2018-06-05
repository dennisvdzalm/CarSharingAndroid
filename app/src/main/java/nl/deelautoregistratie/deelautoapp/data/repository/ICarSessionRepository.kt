package nl.deelautoregistratie.deelautoapp.data.repository

import nl.deelautoregistratie.deelautoapp.data.ListDataObject
import nl.deelautoregistratie.deelautoapp.data.model.CarSession

interface ICarSessionRepository {
    fun getCarSessions() : ListDataObject<CarSession>
}