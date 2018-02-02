package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy.OnlineVideoProxy;

class AppBrandOnlineVideoProxy$OnlineVideoProxy$2 implements Creator<OnlineVideoProxy> {
    AppBrandOnlineVideoProxy$OnlineVideoProxy$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OnlineVideoProxy(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OnlineVideoProxy[i];
    }
}
