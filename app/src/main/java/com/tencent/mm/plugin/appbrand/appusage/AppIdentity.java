package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppIdentity implements Parcelable {
    public static final Creator<AppIdentity> CREATOR = new 1();
    public final int iKd;
    public final String username;

    public AppIdentity(String str, int i) {
        this.username = str;
        this.iKd = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.iKd);
    }

    protected AppIdentity(Parcel parcel) {
        this.username = parcel.readString();
        this.iKd = parcel.readInt();
    }
}
