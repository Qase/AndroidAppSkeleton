package com.qase.android.appskeletondemo

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.qase.android.appskeleton.BaseMainActivity
import com.qase.android.appskeletondemo.main.preference.SettingsFragment
import com.qase.android.appskeletondemo.main.test.TestFragment
import com.qase.android.appskeletondemo.main.test.TestFragment2
import com.qase.android.appskeletondemo.main.test.TestFragment3
import com.qase.android.appskeletondemo.main.testviewmodel.TestvmBundle
import com.qase.android.appskeletondemo.main.testviewmodel.TestvmFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : BaseMainActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.activity = this

        // Set initial fragment
        if (savedInstanceState == null) {
            App.instance.fragmentManager.changeFragment(TestFragment::class.java, TestFragment::class.java.getSimpleName())
        }

        // Main layout setup
        setSupportActionBar(toolbar)

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    /**
     * Context menu override to set menu def
     * @param menu
     * *
     * @return
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.context, menu)
        return true
    }

    /**
     * Context menu onclick
     * @param item
     * *
     * @return
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.menu_item_1) {
            App.instance.fragmentManager.changeFragment(TestFragment::class.java, TestFragment::class.java.getSimpleName())
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Main menu onclick
     * @param item
     * *
     * @return
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.menu_item_1) {
            App.instance.fragmentManager.changeFragment(TestFragment::class.java, TestFragment::class.java.getSimpleName())
        } else if (id == R.id.menu_item_2) {
            App.instance.fragmentManager.changeFragment(TestFragment2::class.java, TestFragment2::class.java.getSimpleName())
        } else if (id == R.id.menu_item_3) {
            App.instance.fragmentManager.changeFragment(TestFragment3::class.java, TestFragment3::class.java.getSimpleName())
        } else if (id == R.id.menu_item_4) {
            App.instance.fragmentManager.changeFragment<TestvmFragment, TestvmBundle>(TestvmFragment::class.java, TestvmFragment::class.java.getSimpleName())
        } else if (id == R.id.menu_item_preferences) {
            App.instance.fragmentManager.changeFragment(SettingsFragment::class.java, SettingsFragment::class.java.getSimpleName())
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}