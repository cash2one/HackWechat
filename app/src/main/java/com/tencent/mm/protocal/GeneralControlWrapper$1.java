package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class GeneralControlWrapper$1 implements Creator<GeneralControlWrapper> {
    GeneralControlWrapper$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GeneralControlWrapper(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GeneralControlWrapper[i];
    }
}
