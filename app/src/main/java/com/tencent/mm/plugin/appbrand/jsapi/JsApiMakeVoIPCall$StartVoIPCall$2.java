package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall.StartVoIPCall;

class JsApiMakeVoIPCall$StartVoIPCall$2 implements Creator<StartVoIPCall> {
    JsApiMakeVoIPCall$StartVoIPCall$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new StartVoIPCall(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new StartVoIPCall[i];
    }
}
