package com.pomelocardsreactnativedemo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;

public class PomeloCardsModule extends ReactContextBaseJavaModule {
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