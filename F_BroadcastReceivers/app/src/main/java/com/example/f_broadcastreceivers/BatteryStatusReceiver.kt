package com.example.f_broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class BatteryStatusReceiver : AppCompatActivity() {
    private val batteryStatusReceiver = BatteryStatusReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery_status_receiver)

        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryStatusReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unregister the receiver when the activity is destroyed
        unregisterReceiver(batteryStatusReceiver)
    }

    class BatteryStatusReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
                val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

                val batteryPercentage = (level.toFloat() / scale.toFloat()) * 100

                val status: Int? = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
                val isCharging =
                    status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL

                val chargingStatus = if (isCharging) "Charging" else "Not Charging"

                val message = "Battery Level: $batteryPercentage%\nCharging Status: $chargingStatus"

                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
        }
    }
}