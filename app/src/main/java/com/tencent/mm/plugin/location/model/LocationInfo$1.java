package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class LocationInfo$1 implements Creator<LocationInfo> {
    LocationInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.nQw = parcel.readString();
        locationInfo.nQx = parcel.readDouble();
        locationInfo.nQy = parcel.readDouble();
        locationInfo.zoom = parcel.readInt();
        locationInfo.nQz = parcel.readString();
        locationInfo.nQA = parcel.readString();
        locationInfo.fDu = parcel.readString();
        locationInfo.nQB = parcel.readString();
        locationInfo.nQC = parcel.readInt();
        return locationInfo;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationInfo[i];
    }
}
