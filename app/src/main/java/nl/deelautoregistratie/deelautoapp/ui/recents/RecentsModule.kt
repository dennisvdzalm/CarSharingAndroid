package nl.deelautoregistratie.deelautoapp.ui.recents

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class RecentsModule {

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable{
        return CompositeDisposable()
    }
}