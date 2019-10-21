package com.example.androidcourse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get.*

class GetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)
        if (intent.action == Intent.ACTION_SEND) {
            tw_get.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        }
    }
}
