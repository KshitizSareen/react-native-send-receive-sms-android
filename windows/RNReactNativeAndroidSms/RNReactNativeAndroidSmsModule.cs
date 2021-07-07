using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Android.Sms.RNReactNativeAndroidSms
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativeAndroidSmsModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativeAndroidSmsModule"/>.
        /// </summary>
        internal RNReactNativeAndroidSmsModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativeAndroidSms";
            }
        }
    }
}
