package nl.deelautoregistratie.deelautoapp.ui.recents

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.data.db.CarSessionDao
import nl.deelautoregistratie.deelautoapp.data.db.CarSessionDatabase

@Module
class RecentsModule {

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable{
        return CompositeDisposable()
    }

    @Provides
    fun provideDatabase(context : Context) : CarSessionDao{
        return CarSessionDatabase.getInstance(context).carSessionDao()
    }
}