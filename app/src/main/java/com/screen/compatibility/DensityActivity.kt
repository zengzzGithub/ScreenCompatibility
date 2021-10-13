package com.screen.compatibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DensityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DensityHandler.setScreenDip(this, 360)
        setContentView(R.layout.activity_density)
    }
}