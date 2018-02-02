package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;

class Orders$DiscountInfo$1 implements Creator<DiscountInfo> {
    Orders$DiscountInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new DiscountInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DiscountInfo[i];
    }
}
