package nl.deelautoregistratie.deelautoapp.data.networking

import android.arch.paging.PagedList
import io.reactivex.Flowable
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import retrofit2.http.GET

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
interface ApiService {

    @GET("carSessions")
    fun getRecentCarSessions() : Flowable<PagedList<CarSession>>
}