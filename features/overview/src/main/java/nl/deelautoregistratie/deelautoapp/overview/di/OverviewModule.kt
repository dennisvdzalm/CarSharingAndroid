package nl.deelautoregistratie.deelautoapp.overview.di

import dagger.Module

@Module(includes = [
    OverviewActivityBuilderModule::class,
    OverviewFragmentBuilderModule::class
])
class OverviewModule