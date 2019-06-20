package com.qase.android.appskeleton.activity

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import com.google.android.material.navigation.NavigationView
import com.qase.android.appskeleton.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Class for creating activity view with toolbar and navigation drawer
 * It has multiple constructors which allow to customize the drawer
 */
open class DefaultDrawerActivityViewHelper(listener: NavigationView.OnNavigationItemSelectedListener) : DrawerActivityViewHelper(listener) {

    constructor(listener: NavigationView.OnNavigationItemSelectedListener, @MenuRes menuRes: Int) : this(listener) {
        this.menuRes = menuRes
    }

    constructor(listener: NavigationView.OnNavigationItemSelectedListener,
                @MenuRes menuRes: Int? = null,
                @DrawableRes headerIconRes: Int? = null,
                @StringRes headerTextPrimaryRes: Int? = null,
                @StringRes headerTextSecondaryRes: Int? = null) : this(listener) {
        this.menuRes = menuRes
        this.headerIconRes = headerIconRes
        this.headerTextPrimaryRes = headerTextPrimaryRes
        this.headerTextSecondaryRes = headerTextSecondaryRes
    }

    constructor(listener: NavigationView.OnNavigationItemSelectedListener,
                @MenuRes menuRes: Int? = null,
                @DrawableRes headerIconRes: Int? = null,
                headerTextPrimary: String? = null,
                headerTextSecondary: String? = null) : this(listener) {
        this.menuRes = menuRes
        this.headerIconRes = headerIconRes
        this.headerTextPrimary = headerTextPrimary
        this.headerTextSecondary = headerTextSecondary
    }

    @LayoutRes
    override val drawerHeaderLayoutRes: Int? = R.layout.main_nav_header

    private var headerImageView: ImageView? = null
    private var headerTextPrimaryView: TextView? = null
    private var headerTextSecondaryView: TextView? = null

    override fun onCreate(activity: BaseMainActivity) {
        super.onCreate(activity)
        headerImageView = activity.nav_view.getHeaderView(0).findViewById(R.id.drawerImageView)
        headerTextPrimaryView = activity.nav_view.getHeaderView(0).findViewById(R.id.drawerTextPrimary)
        headerTextSecondaryView = activity.nav_view.getHeaderView(0).findViewById(R.id.drawerTextSecondary)

        headerIconRes?.let {
            headerImageView?.setImageResource(it)
        }

        headerTextPrimary?.let {
            headerTextPrimaryView?.setText(it)
        }
        headerTextPrimaryRes?.let {
            headerTextPrimaryView?.setText(it)
        }

        headerTextSecondary?.let {
            headerTextSecondaryView?.setText(it)
        }
        headerTextSecondaryRes?.let {
            headerTextSecondaryView?.setText(it)
        }
    }

    var headerIconRes: Int? = null
    var headerTextPrimary: String? = null
        set(value) {
            field = value
            value?.let {
                headerTextPrimaryRes = null
                headerTextPrimaryView?.setText(it)
            }
        }
    var headerTextPrimaryRes: Int? = null
        set(value) {
            field = value
            value?.let {
                headerTextPrimary = null
                headerTextPrimaryView?.setText(it)
            }
        }
    var headerTextSecondary: String? = null
        set(value) {
            field = value
            value?.let {
                headerTextSecondaryRes = null
                headerTextSecondaryView?.setText(it)
            }
        }
    var headerTextSecondaryRes: Int? = null
        set(value) {
            field = value
            value?.let {
                headerTextSecondary = null
                headerTextSecondaryView?.setText(it)
            }
        }

}