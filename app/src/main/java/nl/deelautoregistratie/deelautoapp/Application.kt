package nl.deelautoregistratie.deelautoapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import nl.deelautoregistratie.deelautoapp.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}