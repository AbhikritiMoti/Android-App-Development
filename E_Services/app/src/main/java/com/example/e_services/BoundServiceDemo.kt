package com.example.e_services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer

class BoundServiceDemo: Service() {
    private val LOG_TAG = "Bound Service"
    private val mBinder: IBinder = MyBinder()
    private var mChronometer: Chronometer?=null

    override fun onCreate() {
        Log.v(LOG_TAG,"in onCreate")
        mChronometer = Chronometer(this)
        mChronometer!!.setBase(SystemClock.elapsedRealtime())
        mChronometer!!.start()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return mBinder
    }

    override fun onRebind(intent: Intent?) {
        Log.v(LOG_TAG,"in onRebind")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.v(LOG_TAG,"in UnBind")
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(LOG_TAG,"in onDestroy")
        mChronometer!!.stop()
    }

    fun getTimestamp():String?{
        val elapsedMills = (SystemClock.elapsedRealtime() - mChronometer!!.base)
        val hours = (elapsedMills/3600000.toInt())
        val minutes = (elapsedMills -hours * 3600000).toInt()/60000
        val seconds = (elapsedMills -hours * 3600000 - minutes * 60000).toInt()/100
        val mills = (elapsedMills - hours * 3600000 -minutes * 60000 -seconds * 1000).toInt()
        return "$hours: $minutes: $seconds: $mills"
    }
}