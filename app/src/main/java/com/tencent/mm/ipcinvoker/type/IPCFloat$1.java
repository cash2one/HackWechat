package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCFloat$1 implements Creator<IPCFloat> {
    IPCFloat$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IPCFloat iPCFloat = new IPCFloat();
        iPCFloat.value = parcel.readFloat();
        return iPCFloat;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCFloat[i];
    }
}
