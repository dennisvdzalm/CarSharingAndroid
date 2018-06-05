package nl.deelautoregistratie.deelautoapp.account

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AccountTypeService : Service() {
    override fun onBind(p0: Intent?): IBinder {
        val authenticator = AccountAuthenticator(this)
        return authenticator.iBinder
    }
}