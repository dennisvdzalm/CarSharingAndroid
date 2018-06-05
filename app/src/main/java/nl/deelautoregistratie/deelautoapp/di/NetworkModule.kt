package nl.deelautoregistratie.deelautoapp.di

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import nl.deelautoregistratie.deelautoapp.BuildConfig
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import nl.deelautoregistratie.deelautoapp.data.networking.AuthenticationInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by dennisvanderzalm on 27-04-18.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient,
                          gsonConverterFactory: GsonConverterFactory,
                          rxJavaCallAdapterFactory: RxJava2CallAdapterFactory): ApiService {

        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(okHttpClient)
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttp(cache: Cache): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(logging)
                .addInterceptor(AuthenticationInterceptor("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xOTIuMTY4LjIuMTk6ODg4OC9sb2dpbiIsImlhdCI6MTUyNzY3MjcwMywiZXhwIjoxNTU5MjA4NzAzLCJuYmYiOjE1Mjc2NzI3MDMsImp0aSI6ImcxQzdXdlpUeXRVNkt5RVkifQ.O2rdQWfX144St8Eq2EAXYSEYvGdTMJFTevULf65OJLg"))
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)

        return client.build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor {
        return Executors.newFixedThreadPool(5)
    }
}