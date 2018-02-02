package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCString$1 implements Creator<IPCString> {
    IPCString$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IPCString iPCString = new IPCString();
        iPCString.value = parcel.readString();
        return iPCString;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCString[i];
    }
}
