package com.pomelocardsreactnativedemo

import android.util.Log
import com.facebook.react.bridge.*
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.pomelo.cards.widgets.ui.card.image.PomeloCardView


class PomeloCardWidgetViewManager(
    private val callerContext: ReactApplicationContext
) : SimpleViewManager<PomeloCardView>() {

    override fun getName() = REACT_CLASS

    companion object {
        const val REACT_CLASS = "PomeloCardWidgetView"
    }

    override fun createViewInstance(context: ThemedReactContext) = PomeloCardView(context.currentActivity!!)

    @ReactProp(name = "setupParams")
    fun setSetupParams(view: PomeloCardView, setupParams: ReadableMap) {
        val name = setupParams.getString("cardholderName") ?: ""
        val lastFourDigits = setupParams.getString("lastFourCardDigits") ?: ""
        val imageUrl = "file:///android_asset/card_image.png"

        view.init(name, lastFourDigits, 0, imageUrl)
    }
}