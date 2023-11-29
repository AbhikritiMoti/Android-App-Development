package com.example.myapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    var sampleVideoView : VideoView? = null
    lateinit var mediaControl: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleVideoView = findViewById(R.id.videoView)
        mediaControl = MediaController(this@MainActivity)

        if(mediaControl == null){

            mediaControl.setAnchorView(sampleVideoView)
        }

        sampleVideoView!!.setMediaController(mediaControl)
        sampleVideoView!!.setZOrderMediaOverlay(true)

        sampleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.screenrecording))

        sampleVideoView!!.requestFocus()
        sampleVideoView!!.setZOrderOnTop(true)

        sampleVideoView!!.start()

        sampleVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "thank you", Toast.LENGTH_LONG).show()
        }
    }
}