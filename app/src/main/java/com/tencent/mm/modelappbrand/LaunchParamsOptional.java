package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LaunchParamsOptional implements Parcelable {
    public static final Creator<LaunchParamsOptional> CREATOR = new 1();
    public String hjA;
    public String hjB;
    public String hjz;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hjz);
        parcel.writeString(this.hjA);
    }

    private LaunchParamsOptional(Parcel parcel) {
        this.hjz = parcel.readString();
        this.hjA = parcel.readString();
    }
}
