package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SightParams$1 implements Creator<SightParams> {
    SightParams$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SightParams(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SightParams[i];
    }
}
