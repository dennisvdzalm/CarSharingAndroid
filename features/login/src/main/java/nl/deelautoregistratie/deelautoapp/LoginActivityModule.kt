package nl.deelautoregistratie.deelautoapp

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.ui.login.LoginFragment
import nl.deelautoregistratie.deelautoapp.ui.login.LoginModule

@Module
abstract class LoginActivityModule{

    @ContributesAndroidInjector(modules = [LoginModule::class])
    internal abstract fun provideLoginFragment(): LoginFragment
}