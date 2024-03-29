/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */
import React, { useEffect } from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import HomeScreen from './screens/HomeScreen';
import CardWidgetScreen from './screens/CardWidgetScreen';
import NativePomeloCardsModule from './pomelo_native_modules/PomeloCardsModule';
import * as constants from './screens/constants'

const Stack = createStackNavigator();

const App = () => {
  useEffect(() => {
    NativePomeloCardsModule.setupSDK(constants.email)
  }, []);
  
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          name="Home"
          component={HomeScreen}
          options={{title: 'Home'}}
        />
        <Stack.Screen
          name="CardWidget"
          component={CardWidgetScreen}
          options={{title: 'Card Widget'}}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};
export default App;