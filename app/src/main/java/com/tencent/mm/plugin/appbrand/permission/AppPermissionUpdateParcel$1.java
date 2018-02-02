package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class AppPermissionUpdateParcel$1 implements Creator<AppPermissionUpdateParcel> {
    AppPermissionUpdateParcel$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AppPermissionUpdateParcel(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AppPermissionUpdateParcel[i];
    }
}
