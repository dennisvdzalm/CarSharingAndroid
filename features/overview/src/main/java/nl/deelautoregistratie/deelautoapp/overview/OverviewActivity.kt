package nl.deelautoregistratie.deelautoapp.overview

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import nl.deelautoregistratie.deelautoapp.overview.databinding.ActivityOverviewBinding
import nl.deelautoregistratie.deelautoapp.overview.recents.RecentsFragment
import timber.log.Timber

class OverviewActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_overview)
        binding.bottomNavigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navigation_home -> supportFragmentManager.beginTransaction()
                        .replace(R.id.container, RecentsFragment.newInstance())
                        .commit()
                R.id.navigation_dashboard -> Timber.d("Dashboard clicked")
                R.id.navigation_notifications -> Timber.d("Notifications clicked")
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecentsFragment.newInstance())
                .commit()
    }
}