// include this line for mocking react-native-gesture-handler
import 'react-native-gesture-handler/jestSetup';

// Mock native module as specified here -> https://github.com/facebook/react-native/issues/28839
jest.mock("react-native", () => {
    const RN = jest.requireActual("react-native"); // use original implementation, which comes with mocks out of the box
  
    // mock modules/components created by assigning to NativeModules
    RN.NativeModules.PomeloCardsModule = {
      configureProps: jest.fn(),
      createNode: jest.fn(),
      connectNodes: jest.fn(),
      connectNodeToView: jest.fn(),
      setupSDK: jest.fn()
    };
  
    // mock modules created through UIManager
    RN.UIManager.getViewManagerConfig = name => {
      if (name === "PomeloCardsModule") {
        return {someMethod: jest.fn()}
      }
      return {};
    };
    return RN;
  });