package com.pomelocardsreactnativedemo.bridge

import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.bridge.*
import com.pomelo.cards.widgets.CardsResult
import com.pomelo.cards.widgets.Configuration
import com.pomelo.cards.widgets.PomeloCards
import com.pomelo.cards.widgets.ui.card.bottomsheet.PomeloCardBottomSheet
import com.pomelocardsreactnativedemo.bridge.data.entities.UserTokenBody
import com.pomelocardsreactnativedemo.bridge.data.repositories.UserTokenRepository
import com.pomelocardsreactnativedemo.bridge.ui.ActivateCardDialog
import com.pomelocardsreactnativedemo.bridge.ui.ChangePinDialog


class PomeloCardsModule(val reactContext: ReactApplicationContext, val userTokenRepository: UserTokenRepository) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = "PomeloCardsModule"

    @ReactMethod
    fun setupSDK(email: String) {
        val configuration = Configuration {
            userTokenRepository.getUserToken(UserTokenBody(email))
        }
        PomeloCards.register(configuration, reactContext.applicationContext)
    }

    @ReactMethod
    fun launchCardListWidget(cardId: String, promise: Promise?) {
        reactContext.currentActivity?.let { activity ->
            UiThreadUtil.runOnUiThread {
                PomeloCardBottomSheet.showSensitiveData(
                    activity,
                    cardId,
                    ""
                ) { result, _ ->
                    when (result) {
                        CardsResult.SUCCESS -> { promise?.resolve(true) }
                        else -> { promise?.reject(result.name) }
                    }
                }
            }
        }
    }

    @ReactMethod
    fun launchChangePinWidget(cardId: String, promise: Promise?) {
        reactContext.currentActivity?.let { activity ->
            UiThreadUtil.runOnUiThread {
                ChangePinDialog(cardId) { result, _ ->
                    when (result) {
                        CardsResult.SUCCESS -> { promise?.resolve(true) }
                        else -> { promise?.reject(result.name) }
                    }
                }.show(activity as AppCompatActivity)
            }
        }
    }

    @ReactMethod
    fun launchActivateCardWidget(promise: Promise?) {
        reactContext.currentActivity?.let { activity ->
            UiThreadUtil.runOnUiThread {
                ActivateCardDialog() { result, _ ->
                    when (result) {
                        CardsResult.SUCCESS -> { promise?.resolve(true) }
                        else -> { promise?.reject(result.name) }
                    }
                }.show(activity as AppCompatActivity)
            }
        }

    }
}