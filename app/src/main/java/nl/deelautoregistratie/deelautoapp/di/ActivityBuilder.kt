package nl.deelautoregistratie.deelautoapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.main.MainActivity
import nl.deelautoregistratie.deelautoapp.main.MainActivityModule

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}
