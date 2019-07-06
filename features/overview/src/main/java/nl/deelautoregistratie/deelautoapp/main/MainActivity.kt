package nl.deelautoregistratie.deelautoapp.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import nl.deelautoregistratie.deelautoapp.R

class MainActivity : DaggerAppCompatActivity() {

//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_home -> {
//                supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.container, RecentsFragment.newInstance())
//                        .commit()
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_dashboard -> {
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_notifications -> {
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}