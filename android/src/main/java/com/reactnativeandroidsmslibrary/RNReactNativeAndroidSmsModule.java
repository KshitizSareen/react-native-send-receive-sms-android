
package com.reactnativeandroidsmslibrary;

import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsManager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;

public class RNReactNativeAndroidSmsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNReactNativeAndroidSmsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNReactNativeAndroidSms";
  }

  @ReactMethod
  public void GetInboxMessages(Integer NumOfMessages,Promise promise){
    Cursor cursor=this.getReactApplicationContext().getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
    if(cursor.moveToFirst())
    {
      int i=0;
      WritableArray messages=new WritableNativeArray();
      do{
        WritableMap msgMap=new WritableNativeMap();


        msgMap.putString("address",cursor.getString(cursor.getColumnIndex("address")));
        msgMap.putString("subject",cursor.getString(cursor.getColumnIndex("subject")));
        msgMap.putString("status",cursor.getString(cursor.getColumnIndex("status")));
        msgMap.putString("body",cursor.getString(cursor.getColumnIndex("body")));
        msgMap.putString("DateOfMessage",cursor.getString(cursor.getColumnIndex("date")));
        msgMap.putString("person",cursor.getString(cursor.getColumnIndex("person")));
        messages.pushMap(msgMap);
        i++;
        cursor.moveToNext();
      }
      while (i<NumOfMessages);
      promise.resolve(messages);
    }else{
      promise.reject("1","Message Box could not be retrieved");
    }

  }

  @ReactMethod
  public void SendSMS(String Message,String PhoneNumber,Promise promise)
  {
    try {
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(PhoneNumber, null, Message, null, null);
      promise.resolve("Message Sent");

    }
    catch (Exception e) {
      promise.reject("Error", e.getMessage());
    }
  }
}