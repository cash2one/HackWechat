package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Location$1 implements Creator<Location> {
    Location$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Location location = new Location();
        location.hxF = parcel.readFloat();
        location.hxG = parcel.readFloat();
        location.accuracy = parcel.readInt();
        location.fBe = parcel.readInt();
        location.mac = parcel.readString();
        location.fBg = parcel.readString();
        return location;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Location[i];
    }
}
