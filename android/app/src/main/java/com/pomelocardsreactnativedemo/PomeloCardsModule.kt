package com.pomelocardsreactnativedemo
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class PomeloCardsModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = "PomeloCardsModule"

    @ReactMethod
    fun setupSDK(email: String) {
        Log.d("PomeloCardsModule", "Setup SDK called with email: $email")
    }

}

