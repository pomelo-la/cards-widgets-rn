package com.pomelocardsreactnativedemo

import android.util.Log
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.pomelo.cards.widgets.CardsResult
import com.pomelo.cards.widgets.Configuration
import com.pomelo.cards.widgets.OnResultListener
import com.pomelo.cards.widgets.PomeloCards
import com.pomelo.cards.widgets.ui.card.bottomsheet.PomeloCardBottomSheet
import com.pomelocardsreactnativedemo.data.entities.UserTokenBody
import com.pomelocardsreactnativedemo.data.repositories.UserTokenRepository
import okhttp3.Dispatcher

class PomeloCardsModule(val reactContext: ReactApplicationContext, val userTokenRepository: UserTokenRepository) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = "PomeloCardsModule"

    @ReactMethod
    fun setupSDK(email: String) {
        Log.d("PomeloCardsModule", "Setup SDK called with email: $email")
        val configuration = Configuration {
            userTokenRepository.getUserToken(UserTokenBody(email))
        }
        PomeloCards.register(configuration, context.applicationContext)
    }

    @ReactMethod
    fun launchCardListWidget(cardId: String, promise: Promise?) {
        Log.d("PomeloCardsModule", "Launch card list event called with cardId: $cardId")
        // PomeloCardBottomSheet.showSensitiveData(context.applicationContext,
        //     cardId,
        //     "DIEGO"
        // ) { result, _ ->
        //     when (result) {
        //         CardsResult.NETWORK_ERROR -> {
        //             Log.d("PomeloCardsModule", "ERROR")
        //         }
        //         CardsResult.BIOMETRIC_ERROR -> {
        //             Log.d("PomeloCardsModule", "ASDF")
        //         }
        //         CardsResult.SUCCESS -> {
        //             Log.d("PomeloCardsModule", "DFDSF")
        //         }
        //     }
        // }
    }

    @ReactMethod
    fun launchChangePinWidget(cardId: String, promise: Promise?) {
        Log.d("PomeloCardsModule", "Launch change pin event called with cardId: $cardId")
    }

    @ReactMethod
    fun launchActivateCardWidget(promise: Promise?) {
        Log.d("PomeloCardsModule", "Launch activate card event called")
    }
}