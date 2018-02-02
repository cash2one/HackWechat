package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CameraPosition$1 implements Creator<CameraPosition> {
    CameraPosition$1() {
    }

    public final CameraPosition createFromParcel(Parcel parcel) {
        float readFloat = parcel.readFloat();
        float readFloat2 = parcel.readFloat();
        return new CameraPosition(new LatLng((double) readFloat, (double) readFloat2), parcel.readFloat());
    }

    public final CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
