package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCDouble$1 implements Creator<IPCDouble> {
    IPCDouble$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IPCDouble iPCDouble = new IPCDouble();
        iPCDouble.value = parcel.readDouble();
        return iPCDouble;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCDouble[i];
    }
}
