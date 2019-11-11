package com.example.androidcourse

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.androidcourse.R.id.nav_host_fragment
import com.example.androidcourse.ui.favorite.FavoriteFragment
import com.example.androidcourse.ui.halloffame.HallFragment
import com.example.androidcourse.ui.home.HomeFragment
import com.example.androidcourse.ui.plans.PlansFragment
import com.example.androidcourse.ui.receive.ReceiveFragment
import com.example.androidcourse.ui.send.SendFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), HallFragment.OnButtonClick, SendFragment.onButtonClick {
    override fun onSendButtonClick(wishes: String, author: String) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
            .replace(nav_host_fragment, ReceiveFragment().apply {
                arguments = Bundle().apply {
                    putString("wishes", wishes)
                    putString("author", author)
                }
            })
            .addToBackStack(null)
            .commit()
    }

    override fun onHallButtonClick() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
            .replace(nav_host_fragment, SendFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        nav_view.setNavigationItemSelectedListener(this::onNavigationItemSelected)
        supportFragmentManager
            .beginTransaction()
            .add(nav_host_fragment, HomeFragment())
            .addToBackStack(null)
            .commit()
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment = when (item.itemId) {
            R.id.nav_home -> HomeFragment()
            R.id.nav_favorite -> FavoriteFragment()
            R.id.nav_planned -> PlansFragment()
            R.id.nav_search -> HallFragment()
            else -> error("Item doesn't exist")
        }
        supportFragmentManager
            .beginTransaction()
            .replace(nav_host_fragment, fragment)
            .addToBackStack(null)
            .commit()
        title = item.title
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
