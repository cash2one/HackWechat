package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MMToClientEvent$2 implements Creator<MMToClientEvent> {
    MMToClientEvent$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MMToClientEvent(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MMToClientEvent[i];
    }
}
