package com.pomelocardsreactnativedemo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.pomelocardsreactnativedemo.data.repositories.UserTokenRepository;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.pomelo.cards.widgets.PomeloCards;
import com.pomelo.cards.widgets.Configuration;
import com.pomelocardsreactnativedemo.data.entities.UserTokenBody;

public class PomeloCardsModule extends ReactContextBaseJavaModule {
    private UserTokenRepository repository = new UserTokenRepository();
    PomeloCardsModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "PomeloCardsModule";
    }

    @ReactMethod
    public void setupSDK(String email) {
        Log.d("PomeloCardsModule", "SetupSDK event called with email: " + email);
        UserTokenBody body = new UserTokenBody(BuildConfig.EMAIL);
        PomeloCards.INSTANCE.register(
                Configuration(repository.getUserToken(body)),
        this
        );
    }

    @ReactMethod
    public void launchCardListWidget(String cardId, Promise promise) {
        Log.d("PomeloCardsModule", "Launch card list event called with cardId: " + cardId);
    }

    @ReactMethod
    public void launchChangePinWidget(String cardId, Promise promise) {
        Log.d("PomeloCardsModule", "Launch change pin event called with cardId: " + cardId);
    }

    @ReactMethod
    public void launchActivateCardWidget(Promise promise) {
        Log.d("PomeloCardsModule", "Launch activate card event called");
    }

}