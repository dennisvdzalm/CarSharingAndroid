package nl.deelautoregistratie.deelautoapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.deelautoregistratie.deelautoapp.di.scopes.PerFragment
import nl.deelautoregistratie.deelautoapp.ui.recents.RecentsFragment
import nl.deelautoregistratie.deelautoapp.ui.recents.RecentsModule

@Module
abstract class FragmentBuilder {

    @PerFragment
    @ContributesAndroidInjector(modules = [RecentsModule::class])
    internal abstract fun provideRecentsFragment(): RecentsFragment
}
