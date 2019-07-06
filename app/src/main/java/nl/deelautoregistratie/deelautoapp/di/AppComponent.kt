package nl.deelautoregistratie.deelautoapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import nl.deelautoregistratie.deelautoapp.Application
import javax.inject.Singleton


/**
 * Created by dennisvanderzalm on 27-04-18.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilder::class,
    FragmentBuilder::class,
    ConfigModule::class
])
interface AppComponent : AndroidInjector<Application>

@Component.Builder
interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent
}