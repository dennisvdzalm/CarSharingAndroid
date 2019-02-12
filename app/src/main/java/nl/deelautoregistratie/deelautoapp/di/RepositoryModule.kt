package nl.deelautoregistratie.deelautoapp.di

import dagger.Binds
import dagger.Module
import nl.deelautregistratie.domain.repository.CarSessionRepository

@Module
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindsCarSessionRepository(carSessionRepository: nl.deelautoregistratie.data.repository.CarSessionRepository): CarSessionRepository
}