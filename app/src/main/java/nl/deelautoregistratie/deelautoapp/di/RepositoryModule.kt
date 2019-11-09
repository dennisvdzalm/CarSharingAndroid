package nl.deelautoregistratie.deelautoapp.di

import dagger.Binds
import dagger.Module
import nl.deelautoregistratie.data.repository.AppCarSessionRepository
import nl.deelautregistratie.domain.repository.CarSessionRepository

@Module
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindsCarSessionRepository(appCarSessionRepository: AppCarSessionRepository): CarSessionRepository
}