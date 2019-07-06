package nl.deelautoregistratie.deelautoapp.di

import dagger.Module
import dagger.Provides
import nl.deelautoregistratie.deelautoapp.BuildConfig
import nl.deelautregistratie.domain.config.ApiConfig

@Module
class ConfigModule{

    @Provides
    fun provideApiConfig(): ApiConfig = ApiConfig(BuildConfig.API_URL)
}