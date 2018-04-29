package nl.deelautoregistratie.deelautoapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import nl.deelautoregistratie.deelautoapp.Application
import nl.deelautoregistratie.deelautoapp.utils.rx.AppScheduler
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import javax.inject.Singleton

/**
 * Created by dennisvanderzalm on 27-04-18.
 */

@Module
class AppModule {

    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideScheduler(): Scheduler {
        return AppScheduler()
    }
}