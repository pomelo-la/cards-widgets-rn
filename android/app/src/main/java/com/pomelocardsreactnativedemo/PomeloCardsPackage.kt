package com.pomelocardsreactnativedemo

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.pomelocardsreactnativedemo.data.repositories.UserTokenRepository

class PomeloCardsPackage(val userTokenRepository: UserTokenRepository) : ReactPackage {

    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ) = listOf(PomeloCardWidgetViewManager(reactContext))

    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ): MutableList<NativeModule> {
        val modules: MutableList<NativeModule> = ArrayList()
        modules.add(PomeloCardsModule(reactContext, userTokenRepository))
        modules.add(PomeloCardWidgetViewModule(reactContext))
        return modules
    }
}