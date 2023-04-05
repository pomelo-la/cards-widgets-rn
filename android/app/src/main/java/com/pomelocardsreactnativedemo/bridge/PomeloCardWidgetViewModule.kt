package com.pomelocardsreactnativedemo.bridge


import android.util.Log
import android.view.View
import com.facebook.react.bridge.*
import com.facebook.react.uimanager.UIManagerModule
import com.pomelo.cards.widgets.CardsResult
import com.pomelo.cards.widgets.ui.card.image.PomeloCardView

class PomeloCardWidgetViewModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = "PomeloCardWidgetViewManager" // Same name than iOS.

    @ReactMethod
    fun showSensitiveData(reactTag: Int, cardId: String, promise: Promise?) {
        withMyView(reactTag, promise) {
            it.showSensitiveData(cardId) { result, _ ->
                when (result) {
                    CardsResult.SUCCESS -> { promise?.resolve(true) }
                    else -> { promise?.reject(result.name) }
                }
            }
        };
    }

    private fun withMyView(viewId: Int, promise: Promise?, handler: (PomeloCardView) -> Unit) {
        val uiManager = reactApplicationContext.getNativeModule(
            UIManagerModule::class.java
        )
        uiManager?.addUIBlock { nativeViewHierarchyManager ->
            val view: View = nativeViewHierarchyManager.resolveView(viewId)
            if (view is PomeloCardView) {
                val cardView: PomeloCardView = view as PomeloCardView
                handler(cardView)
            } else {
                Log.e("PomeloCardWidgetView", "Expected view to be instance of MyView, but found: $view")
                promise?.reject("PomeloCardWidgetView", "Unexpected view type")
            }
        }
    }


}