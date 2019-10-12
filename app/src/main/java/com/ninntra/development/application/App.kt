package com.ninntra.development.application

import android.app.Application
import android.content.res.Configuration

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        print("Hello world")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        print("Hello world")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        print("memory is very low")
    }
}