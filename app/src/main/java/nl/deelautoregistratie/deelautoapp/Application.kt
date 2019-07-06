package nl.deelautoregistratie.deelautoapp

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import nl.deelautoregistratie.deelautoapp.di.DaggerAppComponent
import javax.inject.Inject


/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class Application : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

}