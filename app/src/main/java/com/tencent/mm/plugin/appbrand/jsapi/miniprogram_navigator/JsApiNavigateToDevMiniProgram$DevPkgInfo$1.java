package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.DevPkgInfo;

class JsApiNavigateToDevMiniProgram$DevPkgInfo$1 implements Creator<DevPkgInfo> {
    JsApiNavigateToDevMiniProgram$DevPkgInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new DevPkgInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DevPkgInfo[i];
    }
}
