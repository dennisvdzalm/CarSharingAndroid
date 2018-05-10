package nl.deelautoregistratie.deelautoapp.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.ui.recents.RecentsFragment
import nl.deelautoregistratie.deelautoapp.ui.recents.RecentsModule

/**
 * Created by dennisvanderzalm on 27-04-18.
 */

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [RecentsModule::class])
    internal abstract fun provideRecentsFragment(): RecentsFragment
}
