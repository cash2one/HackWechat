package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;

class Orders$DeductInfo$1 implements Creator<DeductInfo> {
    Orders$DeductInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new DeductInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DeductInfo[i];
    }
}
