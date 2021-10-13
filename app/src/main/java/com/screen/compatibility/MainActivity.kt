package com.screen.compatibility

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.default1).setOnClickListener { startActivity(Intent(this, DefaultActivity::class.java)) }
        findViewById<View>(R.id.small).setOnClickListener { startActivity(Intent(this, SmallActivity::class.java)) }
        findViewById<View>(R.id.density).setOnClickListener { startActivity(Intent(this, DensityActivity::class.java)) }
    }
}