package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.sdk.platformtools.bh;

class LocationIntent$1 implements Creator<LocationIntent> {
    LocationIntent$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        LocationIntent locationIntent = new LocationIntent();
        locationIntent.lat = parcel.readDouble();
        locationIntent.lng = parcel.readDouble();
        locationIntent.fzv = parcel.readInt();
        locationIntent.label = parcel.readString();
        locationIntent.nTe = bh.az(parcel.readString(), "");
        locationIntent.vcT = bh.az(parcel.readString(), "");
        locationIntent.nQB = bh.az(parcel.readString(), "");
        locationIntent.vcU = parcel.readInt();
        locationIntent.hxN = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
        return locationIntent;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationIntent[i];
    }
}
