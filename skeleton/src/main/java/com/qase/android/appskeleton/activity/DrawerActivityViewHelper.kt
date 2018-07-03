package com.qase.android.appskeleton.activity

import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.qase.android.appskeleton.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*

abstract class DrawerActivityViewHelper(private val listener: NavigationView.OnNavigationItemSelectedListener) : BaseActivityViewHelper() {

    abstract val openDrawerContentDescRes: Int

    abstract val closeDrawerContentDescRes: Int

    override val mainLayoutRes: Int = R.layout.activity_main

    protected var menuRes: Int? = null

    open val drawerHeaderLayoutRes: Int? = null

    override fun onCreate(activity: BaseMainActivity) {
        // Main layout setup
        activity.setSupportActionBar(activity.toolbar)

        val drawer = activity.findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(activity, drawer, activity.toolbar, openDrawerContentDescRes, closeDrawerContentDescRes)
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