package nl.deelautoregistratie.deelautoapp.login.di

import dagger.Module

@Module(includes = [
    LoginActivityBuilderModule::class,
    LoginFragmentBuilderModule::class
])
class LoginModule