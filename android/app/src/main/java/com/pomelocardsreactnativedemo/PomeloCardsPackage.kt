package com.pomelocardsreactnativedemo

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.pomelocardsreactnativedemo.data.repositories.UserTokenRepository

class PomeloCardsPackage(val userTokenRepository: UserTokenRepository) : ReactPackage {


    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return emptyList()
    }

    override fun createNativeModules(
        reactContext: ReactApplicationContext,
    ): List<NativeModule> {
        val modules: MutableList<NativeModule> = ArrayList()
        modules.add(PomeloCardsModule(reactContext, userTokenRepository))
        return modules
    }
}