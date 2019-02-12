package nl.deelautoregistratie.data.retrofit.services

import io.reactivex.Single
import nl.deelautoregistratie.data.model.CarSessionJson
import nl.deelautregistratie.domain.model.CarSession
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
interface CarSessionService {

    @POST("getCarSessions")
    fun getRecentCarSessions(@Query("page") page: Int): Single<List<CarSessionJson>>
}