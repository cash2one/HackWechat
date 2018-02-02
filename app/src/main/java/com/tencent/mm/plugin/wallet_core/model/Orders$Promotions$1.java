package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;

class Orders$Promotions$1 implements Creator<Promotions> {
    Orders$Promotions$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Promotions(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Promotions[i];
    }
}
