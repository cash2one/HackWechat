package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ModulePkgInfo$1 implements Creator<ModulePkgInfo> {
    ModulePkgInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ModulePkgInfo(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ModulePkgInfo[i];
    }
}
