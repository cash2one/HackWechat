package com.tencent.mm.plugin.webview.ui.tools;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class WebViewStubCallbackWrapper$1 implements Creator<WebViewStubCallbackWrapper> {
    WebViewStubCallbackWrapper$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        return readStrongBinder != null ? new WebViewStubCallbackWrapper(readStrongBinder, (byte) 0) : null;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WebViewStubCallbackWrapper[i];
    }
}
