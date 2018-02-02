package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ShareInfo implements Parcelable {
    public static final Creator<ShareInfo> CREATOR = new 1();
    public String hjA;
    public String hjz;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hjA);
        parcel.writeString(this.hjz);
    }

    public ShareInfo(String str, String str2) {
        this.hjA = str;
        this.hjz = str2;
    }

    private ShareInfo(Parcel parcel) {
        this.hjA = parcel.readString();
        this.hjz = parcel.readString();
    }
}
