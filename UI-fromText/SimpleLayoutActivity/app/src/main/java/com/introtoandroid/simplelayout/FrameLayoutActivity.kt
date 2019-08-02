package com.introtoandroid.simplelayout


import android.os.Bundle

class FrameLayoutActivity : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_layout)
        this.getActionBar().setTitle("Frame Layout")
    }

}
