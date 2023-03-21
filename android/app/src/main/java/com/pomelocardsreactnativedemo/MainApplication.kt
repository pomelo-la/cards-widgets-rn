package com.pomelocardsreactnativedemo

import android.app.Application
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.PackageList
import com.facebook.soloader.SoLoader
import com.pomelocardsreactnativedemo.data.repositories.UserTokenRepository
import com.pomelocardsreactnativedemo.di.MainModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MainApplication : Application(), ReactApplication {
    val userTokenRepository: UserTokenRepository by inject()

    private val mReactNativeHost: ReactNativeHost = object : DefaultReactNativeHost(this) {
        override fun getUseDeveloperSupport(): Boolean {
            return BuildConfig.DEBUG
        }

        override fun getPackages(): List<ReactPackage> {
            val packages: MutableList<ReactPackage> = PackageList(this).packages
            // Packages that cannot be autolinked yet can be added manually here, for example:
            packages.add(PomeloCardsPackage(userTokenRepository))
            return packages
        }

        override fun getJSMainModuleName(): String {
            return "index"
        }

        override val isNewArchEnabled: Boolean
            protected get() = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
        override val isHermesEnabled: Boolean
            protected get() = BuildConfig.IS_HERMES_ENABLED
    }

    override fun getReactNativeHost(): ReactNativeHost {
        return mReactNativeHost
    }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this,  /* native exopackage */false)
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            // If you opted-in for the New Architecture, we load the native entry point for this app.
            load()
        }
        ReactNativeFlipper.initializeFlipper(this, reactNativeHost.reactInstanceManager)
        startAppKoin()
    }

    private fun startAppKoin() {
        val modules = listOf(MainModule.initModule())
        GlobalContext.getOrNull()?.apply {
            loadKoinModules(modules)
        } ?: startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}