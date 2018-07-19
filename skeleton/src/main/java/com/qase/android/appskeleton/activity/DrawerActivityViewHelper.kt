package com.qase.android.appskeleton.activity

import android.support.annotation.LayoutRes
import android.support.annotation.MenuRes
import android.support.annotation.StringRes
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
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