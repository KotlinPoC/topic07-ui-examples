package com.introtoandroid.simplelayout


import android.os.Bundle

class TableLayoutActivity : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_layout)
        this.getActionBar().setTitle("Table Layout")
    }

}