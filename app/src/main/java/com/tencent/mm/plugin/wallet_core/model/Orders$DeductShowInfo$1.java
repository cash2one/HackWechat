package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;

class Orders$DeductShowInfo$1 implements Creator<DeductShowInfo> {
    Orders$DeductShowInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new DeductShowInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DeductShowInfo[i];
    }
}
