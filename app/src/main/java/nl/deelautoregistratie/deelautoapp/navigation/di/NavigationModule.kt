package nl.deelautoregistratie.deelautoapp.navigation.di

import dagger.Binds
import dagger.Module
import nl.deelautoregistratie.deelautoapp.login.LoginNavigation
import nl.deelautoregistratie.deelautoapp.main.MainNavigator
import nl.deelautoregistratie.deelautoapp.navigation.LoginCoordinator
import nl.deelautoregistratie.deelautoapp.navigation.MainCoordinator
import nl.deelautoregistratie.deelautoapp.navigation.OverviewCoordinator
import nl.deelautoregistratie.deelautoapp.overview.OverviewNavigator

@Module
abstract class NavigationModule {

    @Binds
    internal abstract fun bindLoginCoordinator(loginCoordinator: LoginCoordinator): LoginNavigation

    @Binds
    internal abstract fun bindMainCoordinator(mainCoordinator: MainCoordinator): MainNavigator

    @Binds
    internal abstract fun bindOverviewCoordinator(overviewCoordinator: OverviewCoordinator): OverviewNavigator
}