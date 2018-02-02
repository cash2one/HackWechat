package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.SyncResult;

class JsApiUpdateApp$SyncResult$1 implements Creator<SyncResult> {
    JsApiUpdateApp$SyncResult$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SyncResult(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SyncResult[i];
    }
}
