package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppPermissionUpdateParcel implements Parcelable {
    public static final Creator<AppPermissionUpdateParcel> CREATOR = new 1();
    public String appId;
    public byte[] jGB;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByteArray(this.jGB);
    }

    private AppPermissionUpdateParcel(Parcel parcel) {
        this.appId = parcel.readString();
        this.jGB = parcel.createByteArray();
    }
}
