package nl.deelautoregistratie.deelautoapp.main

import android.content.Context

interface MainNavigator {

    fun goToLogin(context: Context)

    fun goToOverview(context: Context)
}