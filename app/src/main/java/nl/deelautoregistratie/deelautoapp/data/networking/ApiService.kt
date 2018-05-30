package nl.deelautoregistratie.deelautoapp.data.networking

import com.google.gson.annotations.SerializedName
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
interface ApiService {

    @POST("getCarSessions")
    fun getRecentCarSessions(@Query("page") page: Int): Call<CarSessions<CarSession>>

    class CarSessions<T>(
            @SerializedName("data")
            val data: List<T>,
            @SerializedName("current_page")
            val currentPage: String?,
            @SerializedName("per_page")
            val perPage: String?)
}