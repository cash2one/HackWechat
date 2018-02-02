package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class JsApiNavigateToDevMiniProgram$DevPkgInfo implements Parcelable {
    public static final Creator<JsApiNavigateToDevMiniProgram$DevPkgInfo> CREATOR = new 1();
    String appId;
    String fIn;
    String fvR;
    String jom;

    JsApiNavigateToDevMiniProgram$DevPkgInfo() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fvR);
        parcel.writeString(this.fIn);
        parcel.writeString(this.jom);
    }

    JsApiNavigateToDevMiniProgram$DevPkgInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.fvR = parcel.readString();
        this.fIn = parcel.readString();
        this.jom = parcel.readString();
    }
}
