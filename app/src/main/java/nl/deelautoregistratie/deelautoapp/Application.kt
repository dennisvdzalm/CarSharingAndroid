package nl.deelautoregistratie.deelautoapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import nl.deelautoregistratie.deelautoapp.di.DaggerAppComponent

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}