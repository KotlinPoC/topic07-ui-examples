package com.introtoandroid.simplelayout


import android.os.Bundle

class RelativeLayoutActivity : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relative_layout)
        this.getActionBar().setTitle("Relative Layout")
    }

}
