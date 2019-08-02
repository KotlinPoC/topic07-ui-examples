package com.introtoandroid.simplelayout


import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem

abstract class MenuActivity : Activity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.simple_layout, menu)

        setIntentOnMenuItem(menu, R.id.frame_menu_item, Intent(this, FrameLayoutActivity::class.java))
        setIntentOnMenuItem(menu, R.id.relative_menu_item, Intent(this, RelativeLayoutActivity::class.java))
        setIntentOnMenuItem(menu, R.id.linear_menu_item, Intent(this, LinearLayoutActivity::class.java))
        setIntentOnMenuItem(menu, R.id.table_menu_item, Intent(this, TableLayoutActivity::class.java))
        setIntentOnMenuItem(menu, R.id.grid_menu_item, Intent(this, GridLayoutActivity::class.java))
        setIntentOnMenuItem(menu, R.id.multi_menu_item, Intent(this, MultipleLayoutActivity::class.java))
        super.onCreateOptionsMenu(menu)
        return true
    }


    private fun setIntentOnMenuItem(menu: Menu, menuId: Int,
                                    intent: Intent) {
        val menuItem = menu.findItem(menuId)
        if (menuItem != null) {
            menuItem.intent = intent
        } else {
            Log.w(DEBUG_TAG, "Warning: Can't find menu item: $menuId")
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(item.intent)

        super.onOptionsItemSelected(item)
        return true
    }

    companion object {
        private val DEBUG_TAG = "MenuActivity"
    }

}
