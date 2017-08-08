package com.dubrovin.igor.redditclient.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.dubrovin.igor.redditclient.R
import com.dubrovin.igor.redditclient.ui.fragment.NewsFragment

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            changeFragment(NewsFragment())
    }

    fun changeFragment(fragment: Fragment, clearStack: Boolean = false){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (clearStack)
            clearBackStack()
        fragmentTransaction.replace(R.id.main_fragment_container, fragment)
                .addToBackStack(null)
                .commit()
    }

    fun clearBackStack(){
        val manager = supportFragmentManager;
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
