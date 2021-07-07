
import { PermissionsAndroid } from "react-native";
import { NativeModules } from 'react-native';
const {RNReactNativeAndroidSms} = NativeModules;
const GetMessages= async (NumOfMessages)=>{
    if(parseInt(NumOfMessages))
    {
    const granted= await PermissionsAndroid.request(PermissionsAndroid.PERMISSIONS.READ_SMS);
      if(granted==PermissionsAndroid.RESULTS.GRANTED)
      {
          var IntNum=parseInt(NumOfMessages);
       var messages= await RNReactNativeAndroidSms.GetInboxMessages(IntNum);
        console.log(messages);
      }
      else
      {
        console.error("Permission Denied");
      }
    }
    else
    {
        console.error("No Valid Input value has been provided");
    }
  }

var SendMessage=async (Message,PhoneNumber)=>{
    const granted= await PermissionsAndroid.request(PermissionsAndroid.PERMISSIONS.SEND_SMS);
      if(granted==PermissionsAndroid.RESULTS.GRANTED)
      {
       var result= await RNReactNativeAndroidSms.SendSMS(Message.toString(),PhoneNumber.toString());
       console.log(result);
    }
    else
    {
        console.error("Permission Denied");
    }
}

  export {GetMessages,SendMessage};