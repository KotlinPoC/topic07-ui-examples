package com.introtoandroid.simplelayout


import android.os.Bundle

class MultipleLayoutActivity : MenuActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multiple_layout)

        this.getActionBar().setTitle("Multiple Layout")
    }
}
