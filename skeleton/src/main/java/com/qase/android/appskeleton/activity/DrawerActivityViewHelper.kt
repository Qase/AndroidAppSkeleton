package com.qase.android.appskeleton.activity


import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.qase.android.appskeleton.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*

/**
 * Abstract class for creating activity with toolbar and navigation drawer
 */
abstract class DrawerActivityViewHelper(private val listener: NavigationView.OnNavigationItemSelectedListener) : BaseActivityViewHelper() {

    @StringRes
    open val openDrawerContentDescRes: Int = R.string.navigation_drawer_open

    @StringRes
    open val closeDrawerContentDescRes: Int = R.string.navigation_drawer_open

    override val mainLayoutRes: Int = R.layout.activity_main

    @MenuRes
    protected var menuRes: Int? = null

    @LayoutRes
    open val drawerHeaderLayoutRes: Int? = null

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(activity: BaseMainActivity) {
        // Main layout setup
        activity.setSupportActionBar(activity.toolbar)

        val drawer = activity.findViewById<View>(R.id.drawer_layout) as DrawerLayout
        toggle = ActionBarDrawerToggle(activity, drawer, activity.toolbar, openDrawerContentDescRes, closeDrawerContentDescRes)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        menuRes?.let {
            activity.nav_view.inflateMenu(it)
        }
        drawerHeaderLayoutRes?.let {
            activity.nav_view.inflateHeaderView(it)
        }
        activity.nav_view.setNavigationItemSelectedListener(listener)

    }

}