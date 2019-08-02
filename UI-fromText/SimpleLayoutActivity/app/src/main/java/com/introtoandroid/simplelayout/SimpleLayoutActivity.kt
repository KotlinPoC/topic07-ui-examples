package com.introtoandroid.simplelayout


import android.os.Bundle

class SimpleLayoutActivity : MenuActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_layout)
        this.getActionBar().setTitle("Simple Layout")

    }
}