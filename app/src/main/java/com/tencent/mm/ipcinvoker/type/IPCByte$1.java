package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCByte$1 implements Creator<IPCByte> {
    IPCByte$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IPCByte iPCByte = new IPCByte();
        iPCByte.value = parcel.readByte();
        return iPCByte;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCByte[i];
    }
}
