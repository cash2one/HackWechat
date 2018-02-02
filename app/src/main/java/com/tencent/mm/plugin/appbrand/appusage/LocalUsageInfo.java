package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocalUsageInfo implements Parcelable {
    public static final Creator<LocalUsageInfo> CREATOR = new 1();
    public final String appId;
    public final String fpL;
    public final int iKd;
    public final String iKm;
    public final String username;

    public LocalUsageInfo(String str, String str2, int i, String str3, String str4) {
        this.username = str;
        this.appId = str2;
        this.iKd = i;
        this.fpL = str3;
        this.iKm = str4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iKd);
        parcel.writeString(this.fpL);
        parcel.writeString(this.iKm);
    }

    private LocalUsageInfo(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.iKd = parcel.readInt();
        this.fpL = parcel.readString();
        this.iKm = parcel.readString();
    }
}
