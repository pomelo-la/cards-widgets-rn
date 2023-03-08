# Getting started

* [Setup](#setup)
  1. Setup iOS workspace
  2. Setup React Native
* [Configuration](#configuration)
  1. Authentication
  2. Theme
* [Usage](#usage)
  1. Setup
  2. Card widget
  3. Card bottom sheet widget
  4. Activate card widget
  5. Change pin widget

# Setup

In this guide we will explain how to setup iOS PomeloCardsSDK on a React Native project.

## 1. Setup iOS workspace

First you need to add PomeloCardsSDK on the iOS workspace (ios/ProjectName.xcworkspace) using Swift Package Dependency.
Select you project, go to `Package Dependencies` and add `git@github.com:pomelo-la/cards-ios.git`
![Add SP Dependency](./documentation/ios-sp-dependency.jpg)

Setup minimum deployment target to iOS 13.0 or later
![Setup minimum deployment](./documentation/ios-min-deploy.jpg)

Setup `NSFaceIDUsageDescription` on info.plist with the apropriate message. Ex: `$(PRODUCT_NAME) uses Face ID to validate your identity`
![Setup NSFaceIDUsageDescription](./documentation/ios-faceid.jpg)

Drag and drop from the demo project the folder `PomeloReactNativeBridge` to your own ios workspace
![Copy iOS files](./documentation/ios-files.jpg)

Xcode should prompt to add a Bridging-Header file automatically once you drag and drop the files, you must accept it:
 ![Bridging Header](./documentation/bridging-header.jpg)

If that's not the case you must create it manually. (https://developer.apple.com/documentation/swift/importing-objective-c-into-swift)

You must add the imports from the demo project on your Bridging-Header.h so Objective-C code becomes visible to the Swift one.

```
#import "React/RCTBridgeModule.h"
#import "React/RCTViewManager.h"
#import "React/RCTUIManager.h"
#import "RCTSwiftLog.h"
```

## 2. Setup React Native

So we have configured PomeloSDK on the iOS side to make it available on React Native, now we will use it.
 
You need to drag and drop from the demo project the folder `pomelo_native_modules` to your own one.

![Copy React Native files](./documentation/rn-files.jpg)

Now you're all set, you can see examples of how you could call iOS Native Modules on react native side on the demo project.

# Configuration
```
  @objc func setupSDK(_ email: String) {
    //Configure Cards SDK
    PomeloCards.initialize(with: PomeloCardsConfiguration(environment: .staging))
    //Configure authorization service on PomeloNetworking
    PomeloNetworkConfigurator.shared.configure(authorizationService: EndUserTokenAuthorizationService(email: email))
    guaranteeMainThread {
      //Configure theme on PomeloUI
      PomeloUIGateway.shared.configure(theme: PomeloTheme())
    }
  }
```
## 1. Authorization
To initialize Pomelo Cards SDK, we need to provide an end user token. All the logic is implemented in swift on the iOS side, you can check how to do that here: https://github.com/pomelo-la/cards-ios/tree/feature/documentation#3-authorization

## 2. Theme
To customize the iOS theme you should setup your own theme as explained here: https://github.com/pomelo-la/cards-ios/tree/feature/documentation#customizing

# Usage

## 1. Setup
When using the SDK you should first call the setup method from the react native side. This method must be called before launching any widget.
```
const App = () => {
  useEffect(() => {
    NativePomeloCardsModule.setupSDK(constants.email)
  }, []);
```

## 2. Card widget
An example of how you can insert PomeloCardView on a React Native one is shown on CardWidgetScreen.js
![Card Widget](./documentation/card-widget.jpg)

## 3. Card bottom sheet widget
An example of how to launch card bottom sheet widget is shown on HomeScreen.js
```
    function launchCardListWidget() {
        NativePomeloCardsModule.launchCardListWidget(constants.cardId).then(res => {
            // Sensitive data load successfully
         })
        .catch(e => { alert(`Show sensitive data failed with error: ${e.toString()}`) })
    }
```
![Card bottom sheet widget](./documentation/card-bottom-sheet.jpg)

## 4. Activate card widget
An example of how to launch activate card widget is shown on HomeScreen.js
```
    function launchActivateCardWidget() {
        NativePomeloCardsModule.launchActivateCardWidget().then(res => {
            // Activate card succeed
         })
        .catch(e => { alert(`Change pin failed with error: ${e.toString()}`) })
    }
```
![Card bottom sheet widget](./documentation/activate-card.jpg)

## 5. Change pin widget
An example of how to launch change pin widget is shown on HomeScreen.js
```
    function launcChangePinWidget() {
        NativePomeloCardsModule.launchChangePinWidget(constants.cardId).then(res => {
            // Pin change succeed
         })
        .catch(e => { alert(`Change pin failed with error: ${e.toString()}`) })
    }
```
![Card bottom sheet widget](./documentation/change-pin.jpg)
