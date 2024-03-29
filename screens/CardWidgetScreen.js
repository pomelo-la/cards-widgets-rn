import React, { useRef } from 'react'
import ReactNative, { Button, SafeAreaView, StyleSheet, View } from 'react-native';
import PomeloCardWidgetViewManager, { PomeloCardView } from '../pomelo_native_modules/PomeloCardWidgetViewManager';
import * as constants from './constants'

const CardWidgetScreen = () => {
    const cardViewRef = useRef(null)

    function showSensitiveData() {
      const tag = ReactNative.findNodeHandle(cardViewRef.current)
      PomeloCardWidgetViewManager.showSensitiveData(tag, constants.cardId)
      .then(res => {
          // Sensitive data load successfully
       })
      .catch(e => { alert(`Show sensitive data failed with error: ${e.toString()}`) })
    }

    return (
      <SafeAreaView style={styles.container}>
        <PomeloCardView 
            style={styles.card}
            ref={cardViewRef}
            setupParams={{cardholderName:constants.cardholderName, lastFourCardDigits:constants.lastFourCardDigits, image: constants.image}}
            />
        <Button
          onPress={() => showSensitiveData()}
          title="Display sensitive data"
          />
      </SafeAreaView>
    );
};

export default CardWidgetScreen;


const styles = StyleSheet.create({
  container: {
      flex: 1,
      margin: 20,
  },
  card: {
    backgroundColor: 'transparent',
    width: '100%',
    height: undefined,
    aspectRatio: 622/384,
    marginBottom: 20
  }
});