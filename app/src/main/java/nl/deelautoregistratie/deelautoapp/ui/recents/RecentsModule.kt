package nl.deelautoregistratie.deelautoapp.ui.recents

import android.content.Context
import dagger.Module
import dagger.Provides
import nl.deelautoregistratie.deelautoapp.data.db.CarSessionDatabase

@Module
class RecentsModule {

    @Provides
    fun provideDatabase(context: Context): CarSessionDatabase {
        return CarSessionDatabase.getInstance(context)
    }
}