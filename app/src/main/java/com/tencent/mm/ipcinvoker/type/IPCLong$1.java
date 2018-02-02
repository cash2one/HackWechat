package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCLong$1 implements Creator<IPCLong> {
    IPCLong$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IPCLong iPCLong = new IPCLong();
        iPCLong.value = parcel.readLong();
        return iPCLong;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCLong[i];
    }
}
