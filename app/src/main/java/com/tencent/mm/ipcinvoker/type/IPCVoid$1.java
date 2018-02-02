package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCVoid$1 implements Creator<IPCVoid> {
    IPCVoid$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new IPCVoid();
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCVoid[i];
    }
}
