package com.introtoandroid.simplelayout


import android.os.Bundle

class LinearLayoutActivity : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout)
        this.getActionBar().setTitle("Linear Layout")
    }

}
