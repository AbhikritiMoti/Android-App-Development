package com.example.e_services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.audiofx.BassBoost
import android.os.IBinder
import android.provider.Settings


class UnboundServices: Service() {
    lateinit var mp: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mp.setLooping(true)
        mp.start()
        return START_STICKY

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
    }

}