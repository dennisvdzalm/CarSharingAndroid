package nl.deelautoregistratie.deelautoapp.overview.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.overview.OverviewActivity

@Module
abstract class OverviewActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideOverviewActivity(): OverviewActivity
}