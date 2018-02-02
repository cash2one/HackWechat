package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class LaunchBroadCast$1 implements Creator<LaunchBroadCast> {
    LaunchBroadCast$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LaunchBroadCast(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LaunchBroadCast[i];
    }
}
