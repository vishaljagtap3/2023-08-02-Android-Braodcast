package com.bitcodetech.broadcastdemo

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBR : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        when {
            intent!!.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED) -> {
                val state = intent.getBooleanExtra("state", false)
                val message = if (state) "Airplane mode ON" else "Airplane Mode off"
                Toast.makeText(context!!, message, Toast.LENGTH_SHORT).show()
            }

            intent!!.action.equals("in.bitcode.download.COMPLETE") ->
                Toast.makeText(
                    context!!,
                    "${intent.getStringExtra("path")}",
                    Toast.LENGTH_SHORT
                ).show()

            else -> Toast.makeText(context!!, intent!!.action, Toast.LENGTH_SHORT).show()
        }

    }
}