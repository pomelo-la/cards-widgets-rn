package com.pomelocardsreactnativedemo

import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import com.pomelocardsreactnativedemo.data.repositories.UserTokenRepository

class PomeloCardsPackage(val userTokenRepository: UserTokenRepository) : ReactPackage {

    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ) = listOf(PomeloCardWidgetViewManager(reactContext))

    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ): MutableList<NativeModule> = listOf(PomeloCardsModule(reactContext, userTokenRepository)).toMutableList()
}