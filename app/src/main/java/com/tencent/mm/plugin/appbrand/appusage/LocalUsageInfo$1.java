package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class LocalUsageInfo$1 implements Creator<LocalUsageInfo> {
    LocalUsageInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LocalUsageInfo(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocalUsageInfo[i];
    }
}
