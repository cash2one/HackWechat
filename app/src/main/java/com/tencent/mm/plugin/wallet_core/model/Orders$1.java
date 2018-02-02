package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Orders$1 implements Creator<Orders> {
    Orders$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Orders(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Orders[i];
    }
}
