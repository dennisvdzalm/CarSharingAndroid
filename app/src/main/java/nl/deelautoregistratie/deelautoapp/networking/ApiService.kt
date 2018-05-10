package nl.deelautoregistratie.deelautoapp.networking

import io.reactivex.Flowable
import nl.deelautoregistratie.deelautoapp.model.CarSession
import retrofit2.http.GET

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
interface ApiService {

    @GET("carSessions")
    fun getRecentCarSessions() : Flowable<List<CarSession>>
}