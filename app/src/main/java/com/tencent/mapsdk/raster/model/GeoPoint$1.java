package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class GeoPoint$1 implements Creator<GeoPoint> {
    GeoPoint$1() {
    }

    public final GeoPoint createFromParcel(Parcel parcel) {
        return new GeoPoint(parcel, null);
    }

    public final GeoPoint[] newArray(int i) {
        return new GeoPoint[i];
    }
}
