package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$DiscountInfo implements Parcelable {
    public static final Creator<Orders$DiscountInfo> CREATOR = new 1();
    public String pKc;
    public double sOz;

    public Orders$DiscountInfo(Parcel parcel) {
        this.sOz = parcel.readDouble();
        this.pKc = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.sOz);
        parcel.writeString(this.pKc);
    }
}
