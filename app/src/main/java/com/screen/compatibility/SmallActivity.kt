package com.screen.compatibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SmallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DensityHandler.reset(this)
        setContentView(R.layout.activity_small)
    }
}