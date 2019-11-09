package nl.deelautoregistratie.deelautoapp.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import nl.deelautoregistratie.deelautoapp.login.databinding.ActivityLoginBinding

class LoginActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        supportFragmentManager.beginTransaction().replace(R.id.container, LoginFragment.newInstance())
    }
}