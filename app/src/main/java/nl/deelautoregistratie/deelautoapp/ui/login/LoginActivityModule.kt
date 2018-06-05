package nl.deelautoregistratie.deelautoapp.ui.login

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.di.scopes.PerFragment

@Module
abstract class LoginActivityModule{

    @PerFragment
    @ContributesAndroidInjector(modules = [LoginModule::class])
    internal abstract fun provideLoginFragment(): LoginFragment
}