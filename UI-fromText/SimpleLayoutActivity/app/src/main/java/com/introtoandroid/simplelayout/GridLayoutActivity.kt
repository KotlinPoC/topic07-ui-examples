package com.introtoandroid.simplelayout


import android.os.Bundle

class GridLayoutActivity : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid_layout)
        this.getActionBar().setTitle("Grid Layout")
    }

}