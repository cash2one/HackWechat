package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask;

class JsApiRefreshSession$RefreshSessionTask$2 implements Creator<RefreshSessionTask> {
    JsApiRefreshSession$RefreshSessionTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RefreshSessionTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RefreshSessionTask[i];
    }
}
