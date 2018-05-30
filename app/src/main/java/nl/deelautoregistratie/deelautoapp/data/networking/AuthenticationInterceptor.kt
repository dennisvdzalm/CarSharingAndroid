package nl.deelautoregistratie.deelautoapp.data.networking

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(private val accesToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("Authorization", "Bearer" + accesToken).build()
        return chain.proceed(request)
    }
}