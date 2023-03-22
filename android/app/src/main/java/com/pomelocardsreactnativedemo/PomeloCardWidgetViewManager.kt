package com.pomelocardsreactnativedemo

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.pomelo.cards.widgets.CardsResult
import com.pomelo.cards.widgets.ui.card.image.PomeloCardView
import com.pomelo.cards.widgets.ui.card.models.CardView

class PomeloCardWidgetViewManager(
    private val callerContext: ReactApplicationContext
) : SimpleViewManager<PomeloCardView>() {

    override fun getName() = REACT_CLASS

    companion object {
        const val REACT_CLASS = "RCTPomeloCardWidget"
    }

    // TODO: Jetpack Compose is not supported, I don't know how to return a Compose view here and keep the return type `PomeloCardView`.
    // TODO: It must init PomeloCardView without any param, they must be set later on setupParams
    override fun createViewInstance(context: ThemedReactContext) = PomeloCardView(
        name = "Juan Perez",
        lastFourDigits = "0334",
        showCardData = false,
        cardId = BuildConfig.CARD_ID,
        onResultListener = { cardsResult, _ ->
            when (cardsResult) {
                CardsResult.NETWORK_ERROR -> {}
                CardsResult.BIOMETRIC_ERROR -> {}
                CardsResult.SUCCESS -> {}
            }
        },
        onHideData = {}
    )



    @ReactProp(name = "setupParams")
    fun setSetupParams(view: PomeloCardView, setupParams: Map<String, String>) {
        // TODO: Setup view params here (name, lastFourDigits, cardId)
    }

}