package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCInteger$1 implements Creator<IPCInteger> {
    IPCInteger$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IPCInteger iPCInteger = new IPCInteger();
        iPCInteger.value = parcel.readInt();
        return iPCInteger;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCInteger[i];
    }
}
