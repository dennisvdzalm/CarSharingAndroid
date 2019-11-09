package nl.deelautoregistratie.deelautoapp.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import nl.deelautoregistratie.data.di.DataSourceModule
import nl.deelautoregistratie.deelautoapp.Application
import nl.deelautoregistratie.deelautoapp.login.di.LoginModule
import nl.deelautoregistratie.deelautoapp.navigation.di.NavigationModule
import nl.deelautoregistratie.deelautoapp.overview.di.OverviewModule
import javax.inject.Singleton


/**
 * Created by dennisvanderzalm on 27-04-18.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    ConfigModule::class,
    DatabaseModule::class,
    DataSourceModule::class,
    RepositoryModule::class,
    NetworkModule::class,
    NavigationModule::class,
    OverviewModule::class,
    LoginModule::class
])
interface AppComponent : AndroidInjector<Application> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<Application>
}

