package nl.deelautoregistratie.deelautoapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.di.scopes.PerActivity
import nl.deelautoregistratie.deelautoapp.ui.login.LoginActivity
import nl.deelautoregistratie.deelautoapp.ui.login.LoginActivityModule
import nl.deelautoregistratie.deelautoapp.ui.main.MainActivity
import nl.deelautoregistratie.deelautoapp.ui.main.MainActivityModule

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity
}
