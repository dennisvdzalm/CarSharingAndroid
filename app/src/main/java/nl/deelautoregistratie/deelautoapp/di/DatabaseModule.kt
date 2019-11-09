package nl.deelautoregistratie.deelautoapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import nl.deelautoregistratie.data.db.CarSessionDatabase

@Module
class DatabaseModule {

    @Provides
    fun provideDataBase(application: Context): CarSessionDatabase {
        return CarSessionDatabase.getInstance(application)
    }
}