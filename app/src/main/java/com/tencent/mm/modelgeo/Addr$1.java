package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Addr$1 implements Creator<Addr> {
    Addr$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Addr addr = new Addr();
        addr.hxu = parcel.readString();
        addr.country = parcel.readString();
        addr.hxv = parcel.readString();
        addr.hxw = parcel.readString();
        addr.hxx = parcel.readString();
        addr.hxy = parcel.readString();
        addr.hxz = parcel.readString();
        addr.hxA = parcel.readString();
        addr.hxB = parcel.readString();
        addr.hxC = parcel.readString();
        addr.hxD = parcel.readString();
        addr.hxF = parcel.readFloat();
        addr.hxG = parcel.readFloat();
        return addr;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Addr[i];
    }
}
