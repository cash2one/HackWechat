package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class AppBrandLaunchErrorAction implements Parcelable {
    public static final a CREATOR = new a();
    public final String appId;
    public final int iKd;

    public abstract void ca(Context context);

    AppBrandLaunchErrorAction(Parcel parcel) {
        this.appId = parcel.readString();
        this.iKd = parcel.readInt();
    }

    AppBrandLaunchErrorAction(String str, int i) {
        this.appId = str;
        this.iKd = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getClass().getName());
        parcel.writeString(this.appId);
        parcel.writeInt(this.iKd);
    }

    public final int describeContents() {
        return 0;
    }
}
