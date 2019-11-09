package nl.deelautoregistratie.deelautoapp.login.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.login.LoginFragment

@Module
abstract class LoginFragmentBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun provideLoginFragment(): LoginFragment
}