package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RcptItem implements Parcelable {
    public static final Creator<RcptItem> CREATOR = new 1();
    public String code = "";
    public String ilY = "";
    public boolean ilZ = false;
    public String name = "";

    public RcptItem(String str, String str2, String str3) {
        this.name = str;
        this.code = str2;
        this.ilY = str3;
    }

    public int describeContents() {
        return 0;
    }

    public RcptItem(Parcel parcel) {
        this.name = parcel.readString();
        this.code = parcel.readString();
        this.ilY = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.code);
        parcel.writeString(this.ilY);
    }
}
