package com.bitcodetech.broadcastdemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitcodetech.broadcastdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var myBr : MyBR
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {

            myBr = MyBR();

            val filter = IntentFilter()
            filter.priority = 1000
            filter.addAction(Intent.ACTION_BATTERY_LOW)
            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            filter.addAction(Intent.ACTION_WALLPAPER_CHANGED)
            filter.addAction("in.bitcode.download.COMPLETE")

            registerReceiver(myBr, filter)
        }

        binding.btnUnRegister.setOnClickListener {
            unregisterReceiver(myBr)
        }
    }
}