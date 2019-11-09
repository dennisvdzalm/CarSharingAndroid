package nl.deelautoregistratie.deelautoapp.login.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.login.LoginActivity

@Module
abstract class LoginActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun provideLoginActivity(): LoginActivity
}