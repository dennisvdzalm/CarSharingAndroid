package nl.deelautoregistratie.data.di

import dagger.Binds
import dagger.Module
import nl.deelautoregistratie.data.source.AccountDatasource
import nl.deelautoregistratie.data.source.CarSessionDataSource
import nl.deelautoregistratie.data.source.fake.FakeAccountDataSource
import nl.deelautoregistratie.data.source.fake.FakeCarSessionDataSource

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindAccountDataSource(fakeAccountDataSource: FakeAccountDataSource): AccountDatasource

    @Binds
    abstract fun bindCarSessionDataSource(fakeCarSessionDataSource: FakeCarSessionDataSource): CarSessionDataSource
}