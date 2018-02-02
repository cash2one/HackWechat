package com.tencent.smtt.sdk;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

class SystemWebChromeClient$GeolocationPermissionsCallbackImpl implements GeolocationPermissionsCallback {
    Callback mCallback;
    final /* synthetic */ SystemWebChromeClient this$0;

    SystemWebChromeClient$GeolocationPermissionsCallbackImpl(SystemWebChromeClient systemWebChromeClient, Callback callback) {
        this.this$0 = systemWebChromeClient;
        this.mCallback = callback;
    }

    public void invoke(String str, boolean z, boolean z2) {
        this.mCallback.invoke(str, z, z2);
    }
}
