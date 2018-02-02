package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCBoolean$1 implements Creator<IPCBoolean> {
    IPCBoolean$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = true;
        IPCBoolean iPCBoolean = new IPCBoolean();
        if (parcel.readInt() != 1) {
            z = false;
        }
        iPCBoolean.value = z;
        return iPCBoolean;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCBoolean[i];
    }
}
