package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class AppIdentity$1 implements Creator<AppIdentity> {
    AppIdentity$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AppIdentity(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AppIdentity[i];
    }
}
