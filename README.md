
# react-native-send-receive-sms-android

## Getting started

`$ npm install react-native-send-receive-sms-android --save`

### Mostly automatic installation

`$ react-native link react-native-send-receive-sms-android`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-send-receive-sms-android` and add `RNReactNativeAndroidSms.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeAndroidSms.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeAndroidSmsPackage;` to the imports at the top of the file
  - Add `new RNReactNativeAndroidSmsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-send-receive-sms-android'
  	project(':react-native-send-receive-sms-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-send-receive-sms-android/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-send-receive-sms-android')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativeAndroidSms.sln` in `node_modules/react-native-send-receive-sms-android/windows/RNReactNativeAndroidSms.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using React.Native.Android.Sms.RNReactNativeAndroidSms;` to the usings at the top of the file
  - Add `new RNReactNativeAndroidSmsPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage for Sending SMS
```javascript
import {} from 'react-native-send-receive-sms-android';

// TODO: What to do with the module?
RNReactNativeAndroidSms;
```
  