package nl.deelautoregistratie.deelautoapp.navigation

import android.content.Context
import android.content.Intent
import nl.deelautoregistratie.deelautoapp.login.LoginActivity
import nl.deelautoregistratie.deelautoapp.main.MainNavigator
import nl.deelautoregistratie.deelautoapp.overview.OverviewActivity
import javax.inject.Inject

class MainCoordinator @Inject constructor() : MainNavigator {
    override fun goToLogin(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }

    override fun goToOverview(context: Context) {
        val intent = Intent(context, OverviewActivity::class.java)
        context.startActivity(intent)
    }
}