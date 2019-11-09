package nl.deelautoregistratie.deelautoapp.overview.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.overview.recents.RecentsFragment
import nl.deelautoregistratie.deelautoapp.overview.recents.RecentsModule

@Module
abstract class OverviewFragmentBuilderModule {

    @ContributesAndroidInjector(modules = [RecentsModule::class])
    abstract fun provideRecentsFragment(): RecentsFragment
}