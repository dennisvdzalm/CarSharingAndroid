package nl.deelautoregistratie.deelautoapp.navigation

import android.content.Context
import android.content.Intent
import nl.deelautoregistratie.deelautoapp.login.LoginNavigation
import nl.deelautoregistratie.deelautoapp.overview.OverviewActivity
import javax.inject.Inject

class LoginCoordinator @Inject constructor(): LoginNavigation {

    override fun goToOverview(context: Context) {
        val intent = Intent(context, OverviewActivity::class.java)
        context.startActivity(intent)
    }
}