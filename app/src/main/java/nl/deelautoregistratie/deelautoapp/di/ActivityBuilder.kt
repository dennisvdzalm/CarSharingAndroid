package nl.deelautoregistratie.deelautoapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.main.MainActivity

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity
}