package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$DeductShowInfo implements Parcelable {
    public static final Creator<Orders$DeductShowInfo> CREATOR = new 1();
    public String name;
    public String url;
    public String value;

    protected Orders$DeductShowInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
        this.url = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
        parcel.writeString(this.url);
    }
}
