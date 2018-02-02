package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BindCardOrder$1 implements Creator<BindCardOrder> {
    BindCardOrder$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BindCardOrder(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BindCardOrder[i];
    }
}
